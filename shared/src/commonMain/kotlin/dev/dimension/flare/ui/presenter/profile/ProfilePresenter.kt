package dev.dimension.flare.ui.presenter.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.paging.compose.collectAsLazyPagingItems
import dev.dimension.flare.common.PagingState
import dev.dimension.flare.common.collectAsState
import dev.dimension.flare.common.onSuccess
import dev.dimension.flare.common.toPagingState
import dev.dimension.flare.data.datasource.microblog.AuthenticatedMicroblogDataSource
import dev.dimension.flare.data.datasource.microblog.DirectMessageDataSource
import dev.dimension.flare.data.datasource.microblog.ListDataSource
import dev.dimension.flare.data.datasource.microblog.ProfileAction
import dev.dimension.flare.data.repository.NoActiveAccountException
import dev.dimension.flare.data.repository.accountServiceProvider
import dev.dimension.flare.model.AccountType
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.ui.model.UiProfile
import dev.dimension.flare.ui.model.UiRelation
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.UiTimeline
import dev.dimension.flare.ui.model.UiUserV2
import dev.dimension.flare.ui.model.collectAsUiState
import dev.dimension.flare.ui.model.flatMap
import dev.dimension.flare.ui.model.map
import dev.dimension.flare.ui.model.mapNotNull
import dev.dimension.flare.ui.model.onSuccess
import dev.dimension.flare.ui.model.toUi
import dev.dimension.flare.ui.presenter.PresenterBase
import dev.dimension.flare.ui.presenter.home.UserState
import dev.dimension.flare.ui.presenter.settings.ImmutableListWrapper
import dev.dimension.flare.ui.presenter.settings.toImmutableListWrapper
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ProfilePresenter(
    private val accountType: AccountType,
    private val userKey: MicroBlogKey?,
) : PresenterBase<ProfileState>() {
    @Composable
    override fun body(): ProfileState {
        val scope = rememberCoroutineScope()
        val accountServiceState = accountServiceProvider(accountType = accountType)
        val userState =
            accountServiceState.map { service ->
                val userId =
                    userKey?.id
                        ?: if (service is AuthenticatedMicroblogDataSource) {
                            service.accountKey.id
                        } else {
                            null
                        }
                if (userId == null) {
                    throw NoActiveAccountException
                } else {
                    remember(service, userKey) {
                        service.userById(userId)
                    }.collectAsState()
                }
            }

        val listState =
            accountServiceState
                .map { service ->
                    val actualUserKey =
                        userKey
                            ?: if (service is AuthenticatedMicroblogDataSource) {
                                service.accountKey
                            } else {
                                null
                            } ?: throw NoActiveAccountException
                    remember(service, userKey) {
                        service.userTimeline(
                            actualUserKey,
                            scope = scope,
                        )
                    }.collectAsLazyPagingItems()
                }.toPagingState()
        val mediaState =
            remember {
                ProfileMediaPresenter(accountType = accountType, userKey = userKey)
            }.body().mediaState
        val relationState =
            accountServiceState.flatMap { service ->
                require(service is AuthenticatedMicroblogDataSource)
                val actualUserKey = userKey ?: service.accountKey
                remember(service, userKey) {
                    service.relation(actualUserKey)
                }.collectAsUiState().value.flatMap { it }
            }

        val isMe =
            accountServiceState.map {
                if (it is AuthenticatedMicroblogDataSource) {
                    it.accountKey == userKey || userKey == null
                } else {
                    false
                }
            }
        val actions =
            accountServiceState.map { service ->
                require(service is AuthenticatedMicroblogDataSource)
                service.profileActions().toImmutableList().toImmutableListWrapper()
            }
        val myAccountKey =
            accountServiceState.mapNotNull {
                if (it is AuthenticatedMicroblogDataSource) {
                    it.accountKey
                } else {
                    null
                }
            }
        val canSendMessage =
            remember(accountServiceState, userKey) {
                accountServiceState.map {
                    if (it is DirectMessageDataSource && userKey != null) {
                        flow<Boolean> {
                            runCatching {
                                it.canSendDirectMessage(userKey)
                            }.getOrElse {
                                false
                            }.let {
                                emit(it)
                            }
                        }
                    } else {
                        flow<Boolean> { emit(false) }
                    }
                }
            }.flatMap { it.collectAsUiState().value }
        return object : ProfileState(
            userState = userState.flatMap { it.toUi() },
            listState = listState,
            mediaState = mediaState,
            relationState = relationState,
            isMe = isMe,
            actions = actions,
            isGuestMode = accountType == AccountType.Guest,
            isListDataSource =
                accountServiceState.map {
                    it is ListDataSource
                },
            myAccountKey = myAccountKey,
            canSendMessage = canSendMessage,
        ) {
            override suspend fun refresh() {
                userState.onSuccess {
                    it.refresh()
                }
                listState.onSuccess {
                    refreshSuspend()
                }
            }

            override fun onProfileActionClick(
                userKey: MicroBlogKey,
                relation: UiRelation,
                action: ProfileAction,
            ) {
                scope.launch {
                    action.invoke(userKey, relation)
                }
            }

            override fun follow(
                userKey: MicroBlogKey,
                data: UiRelation,
            ) {
                scope.launch {
                    accountServiceState.onSuccess { service ->
                        if (service is AuthenticatedMicroblogDataSource) {
                            service.follow(userKey, data)
                        }
                    }
                }
            }

            override fun report(userKey: MicroBlogKey) {
            }
        }
    }
}

abstract class ProfileState(
    val userState: UiState<UiProfile>,
    val listState: PagingState<UiTimeline>,
    val mediaState: PagingState<ProfileMedia>,
    val relationState: UiState<UiRelation>,
    val isMe: UiState<Boolean>,
    val actions: UiState<ImmutableListWrapper<ProfileAction>>,
    val isGuestMode: Boolean,
    val isListDataSource: UiState<Boolean>,
    val myAccountKey: UiState<MicroBlogKey>,
    val canSendMessage: UiState<Boolean>,
) {
    abstract suspend fun refresh()

    abstract fun follow(
        userKey: MicroBlogKey,
        data: UiRelation,
    )

    abstract fun onProfileActionClick(
        userKey: MicroBlogKey,
        relation: UiRelation,
        action: ProfileAction,
    )

    abstract fun report(userKey: MicroBlogKey)
}

class ProfileWithUserNameAndHostPresenter(
    private val userName: String,
    private val host: String,
    private val accountType: AccountType,
) : PresenterBase<UserState>() {
    @Composable
    override fun body(): UserState {
        val userState =
            accountServiceProvider(accountType = accountType).flatMap { service ->
                remember(service) {
                    service.userByAcct("$userName@$host")
                }.collectAsState().toUi()
            }
        return object : UserState {
            override val user: UiState<UiUserV2>
                get() = userState
        }
    }
}
