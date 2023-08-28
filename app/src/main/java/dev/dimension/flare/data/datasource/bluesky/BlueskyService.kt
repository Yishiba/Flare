package dev.dimension.flare.data.datasource.bluesky

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.bsky.actor.GetProfileQueryParams
import com.moriatsushi.koject.lazyInject
import dev.dimension.flare.common.CacheData
import dev.dimension.flare.common.Cacheable
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.database.cache.mapper.toDbUser
import dev.dimension.flare.data.datasource.MicroblogService
import dev.dimension.flare.data.datasource.NotificationFilter
import dev.dimension.flare.data.network.bluesky.getService
import dev.dimension.flare.data.repository.app.UiAccount
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.model.PlatformType
import dev.dimension.flare.ui.UiState
import dev.dimension.flare.ui.flatMap
import dev.dimension.flare.ui.model.UiRelation
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.UiUser
import dev.dimension.flare.ui.model.mapper.toUi
import dev.dimension.flare.ui.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import sh.christian.ozone.api.AtIdentifier

internal class BlueskyService(
    private val account: UiAccount.Bluesky,
) : MicroblogService {
    private val database: CacheDatabase by lazyInject()
    override fun homeTimeline(pageSize: Int, pagingKey: String): Flow<PagingData<UiStatus>> = Pager(
        config = PagingConfig(pageSize = pageSize),
    ) {
        HomeTimelinePagingSource(account)
    }.flow

    override fun notification(
        type: NotificationFilter,
        pageSize: Int,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> = Pager(
        config = PagingConfig(pageSize = pageSize),
    ) {
        NotificationPagingSrouce(account)
    }.flow

    override val supportedNotificationFilter: List<NotificationFilter>
        get() = listOf(NotificationFilter.All)

    override fun userByAcct(acct: String): CacheData<UiUser> {
        val (name, host) = MicroBlogKey.valueOf(acct)
        return Cacheable(
            fetchSource = {
                val user = account.getService()
                    .getProfile(GetProfileQueryParams(actor = AtIdentifier(atIdentifier = name)))
                    .requireResponse()
                    .toDbUser(account.accountKey.host)
                database.userDao().insertAll(listOf(user))
            },
            cacheSource = {
                database.userDao().getUserByHandleAndHost(name, host, PlatformType.Bluesky)
                    .mapNotNull { it?.toUi() }
            },
        )
    }

    override fun userById(id: String): CacheData<UiUser> {
        return Cacheable(
            fetchSource = {
                val user = account.getService()
                    .getProfile(GetProfileQueryParams(actor = AtIdentifier(atIdentifier = id)))
                    .requireResponse()
                    .toDbUser(account.accountKey.host)
                database.userDao().insertAll(listOf(user))
            },
            cacheSource = {
                database.userDao().getUser(MicroBlogKey(id, account.accountKey.host))
                    .mapNotNull { it?.toUi() }
            },
        )
    }

    override fun relation(userKey: MicroBlogKey): Flow<UiState<UiRelation>> {
        return userById(userKey.id).toUi().map {
            it.flatMap {
                if (it is UiUser.Misskey) {
                    UiState.Success(it.relation)
                } else {
                    UiState.Error(IllegalStateException("User is not a Misskey user"))
                }
            }
        }
    }

    override fun userTimeline(
        userKey: MicroBlogKey,
        pageSize: Int,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> =
        Pager(
            config = PagingConfig(pageSize = pageSize),
        ) {
            UserTimelinePagingSource(
                account = account,
                userKey = userKey,
            )
        }.flow

    override fun context(
        statusKey: MicroBlogKey,
        pageSize: Int,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> =
        Pager(
            config = PagingConfig(pageSize = pageSize),
        ) {
            StatusDetailPagingSource(
                statusOnly = false,
                account = account,
                statusKey = statusKey,
            )
        }.flow

    override fun status(statusKey: MicroBlogKey, pagingKey: String): Flow<PagingData<UiStatus>> =
        Pager(
            config = PagingConfig(pageSize = 20),
        ) {
            StatusDetailPagingSource(
                statusOnly = true,
                account = account,
                statusKey = statusKey,
            )
        }.flow
}
