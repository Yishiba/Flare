package dev.dimension.flare.data.datasource.vvo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneNotNull
import dev.dimension.flare.common.CacheData
import dev.dimension.flare.common.Cacheable
import dev.dimension.flare.common.FileItem
import dev.dimension.flare.common.MemCacheable
import dev.dimension.flare.common.decodeJson
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.database.cache.mapper.VVO
import dev.dimension.flare.data.database.cache.mapper.toDbUser
import dev.dimension.flare.data.database.cache.model.StatusContent
import dev.dimension.flare.data.database.cache.model.updateStatusUseCase
import dev.dimension.flare.data.datasource.microblog.ComposeConfig
import dev.dimension.flare.data.datasource.microblog.ComposeData
import dev.dimension.flare.data.datasource.microblog.ComposeProgress
import dev.dimension.flare.data.datasource.microblog.MicroblogDataSource
import dev.dimension.flare.data.datasource.microblog.NotificationFilter
import dev.dimension.flare.data.datasource.microblog.ProfileAction
import dev.dimension.flare.data.datasource.microblog.VVOComposeData
import dev.dimension.flare.data.datasource.microblog.relationKeyWithUserKey
import dev.dimension.flare.data.datasource.microblog.timelinePager
import dev.dimension.flare.data.network.vvo.VVOService
import dev.dimension.flare.data.network.vvo.model.StatusDetailItem
import dev.dimension.flare.data.repository.LocalFilterRepository
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.model.PlatformType
import dev.dimension.flare.ui.model.UiAccount
import dev.dimension.flare.ui.model.UiHashtag
import dev.dimension.flare.ui.model.UiRelation
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.UiUser
import dev.dimension.flare.ui.model.mapper.toUi
import dev.dimension.flare.ui.model.toUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(ExperimentalPagingApi::class)
class VVODataSource(
    override val account: UiAccount.VVo,
) : MicroblogDataSource,
    KoinComponent {
    private val database: CacheDatabase by inject()
    private val localFilterRepository: LocalFilterRepository by inject()
    private val service by lazy {
        VVOService(account.credential.chocolate)
    }

    override fun homeTimeline(
        pageSize: Int,
        pagingKey: String,
        scope: CoroutineScope,
    ): Flow<PagingData<UiStatus>> =
        timelinePager(
            pageSize = pageSize,
            pagingKey = pagingKey,
            accountKey = account.accountKey,
            database = database,
            filterFlow = localFilterRepository.getFlow(forTimeline = true),
            scope = scope,
            mediator =
                HomeTimelineRemoteMediator(
                    service,
                    database,
                    account.accountKey,
                    pagingKey,
                ),
        )

    override fun notification(
        type: NotificationFilter,
        pageSize: Int,
        pagingKey: String,
        scope: CoroutineScope,
    ): Flow<PagingData<UiStatus>> =
        when (type) {
            NotificationFilter.All -> TODO()
            NotificationFilter.Mention ->
                timelinePager(
                    pageSize = pageSize,
                    pagingKey = pagingKey,
                    accountKey = account.accountKey,
                    database = database,
                    filterFlow = localFilterRepository.getFlow(forTimeline = true),
                    scope = scope,
                    mediator =
                        MentionRemoteMediator(
                            service,
                            database,
                            account.accountKey,
                            pagingKey,
                        ),
                )

            NotificationFilter.Comment ->
                Pager(
                    config = PagingConfig(pageSize = pageSize),
                ) {
                    CommentPagingSource(
                        service = service,
                        accountKey = account.accountKey,
                    )
                }.flow.cachedIn(scope)

            NotificationFilter.Like ->
                Pager(
                    config = PagingConfig(pageSize = pageSize),
                ) {
                    LikePagingSource(
                        service = service,
                        accountKey = account.accountKey,
                    )
                }.flow.cachedIn(scope)
        }

    override val supportedNotificationFilter: List<NotificationFilter>
        get() =
            listOf(
                NotificationFilter.Mention,
                NotificationFilter.Comment,
                NotificationFilter.Like,
            )

    override fun userByAcct(acct: String): CacheData<UiUser> {
        val (name, host) = MicroBlogKey.valueOf(acct.removePrefix("@"))
        return Cacheable(
            fetchSource = {
                val config = service.config()
                val uid = service.getUid(name)
                requireNotNull(uid) { "user not found" }
                val st = config.data?.st
                requireNotNull(st) { "st is null" }
                val profile = service.profileInfo(uid, st)
                val user = profile.data?.user?.toDbUser()
                requireNotNull(user) { "user not found" }
                database.dbUserQueries.insert(
                    user_key = user.user_key,
                    platform_type = user.platform_type,
                    name = user.name,
                    handle = user.handle,
                    host = user.host,
                    content = user.content,
                )
            },
            cacheSource = {
                database.dbUserQueries
                    .findByHandleAndHost(name, host, PlatformType.VVo)
                    .asFlow()
                    .mapToOneNotNull(Dispatchers.IO)
                    .map { it.toUi(account.accountKey) }
            },
        )
    }

    override fun userById(id: String): CacheData<UiUser> {
        val userKey = MicroBlogKey(id, account.accountKey.host)
        return Cacheable(
            fetchSource = {
                val config = service.config()
                val st = config.data?.st
                requireNotNull(st) { "st is null" }
                val profile = service.profileInfo(id, st)
                val user = profile.data?.user?.toDbUser()
                requireNotNull(user) { "user not found" }
                database.dbUserQueries.insert(
                    user_key = user.user_key,
                    platform_type = user.platform_type,
                    name = user.name,
                    handle = user.handle,
                    host = user.host,
                    content = user.content,
                )
            },
            cacheSource = {
                database.dbUserQueries
                    .findByKey(userKey)
                    .asFlow()
                    .mapToOneNotNull(Dispatchers.IO)
                    .map { it.toUi(account.accountKey) }
            },
        )
    }

    override fun relation(userKey: MicroBlogKey): Flow<UiState<UiRelation>> =
        MemCacheable<UiRelation>(
            relationKeyWithUserKey(userKey),
        ) {
            val config = service.config()
            val st = config.data?.st
            requireNotNull(st) { "st is null" }
            val profile = service.profileInfo(userKey.id, st)
            val user =
                profile.data
                    ?.user
                    ?.toDbUser()
                    ?.toUi(account.accountKey)
            requireNotNull(user) { "user not found" }
            require(user is UiUser.VVO)
            user.relation
        }.toUi()

    override fun userTimeline(
        userKey: MicroBlogKey,
        scope: CoroutineScope,
        pageSize: Int,
        mediaOnly: Boolean,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> =
        timelinePager(
            pageSize = pageSize,
            pagingKey = pagingKey,
            accountKey = account.accountKey,
            database = database,
            filterFlow = localFilterRepository.getFlow(forTimeline = true),
            scope = scope,
            mediator =
                UserTimelineRemoteMediator(
                    userKey = userKey,
                    service = service,
                    database = database,
                    accountKey = account.accountKey,
                    pagingKey = pagingKey,
                    mediaOnly = mediaOnly,
                ),
        )

    override fun context(
        statusKey: MicroBlogKey,
        scope: CoroutineScope,
        pageSize: Int,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> {
        TODO("Not yet implemented")
    }

    override fun status(statusKey: MicroBlogKey): CacheData<UiStatus> {
        val pagingKey = "status_only_$statusKey"
        val regex =
            "\\\$render_data\\s*=\\s*(\\[\\{.*?\\}\\])\\[0\\]\\s*\\|\\|\\s*\\{\\};"
                .toRegex()
        return Cacheable(
            fetchSource = {
                val response =
                    service
                        .getStatusDetail(statusKey.id)
                        .split("\n")
                        .joinToString("")
                val json =
                    regex
                        .find(response)
                        ?.groupValues
                        ?.get(1)
                        ?.decodeJson<List<StatusDetailItem>>()
                        ?: throw Exception("status not found")
                val item = json.firstOrNull()?.status

                if (item != null) {
                    VVO.save(
                        accountKey = account.accountKey,
                        pagingKey = pagingKey,
                        database = database,
                        statuses = listOf(item),
                    )
                } else {
                    throw Exception("status not found")
                }
            },
            cacheSource = {
                database.dbStatusQueries
                    .get(statusKey, account.accountKey)
                    .asFlow()
                    .mapToOneNotNull(Dispatchers.IO)
                    .mapNotNull { it.content.toUi(account.accountKey) }
            },
        )
    }

    private suspend fun uploadMedia(
        fileItem: FileItem,
        st: String,
    ): String {
        val bytes = fileItem.readBytes()
        val response =
            service.uploadPic(
                st = st,
                bytes = bytes,
                filename = fileItem.name ?: "file",
            )
        return response.picID ?: throw Exception("upload failed")
    }

    override suspend fun compose(
        data: ComposeData,
        progress: (ComposeProgress) -> Unit,
    ) {
        require(data is VVOComposeData)
        val maxProgress = data.medias.size + 1
        val config = service.config()
        val st = config.data?.st
        requireNotNull(st) { "st is null" }
        val mediaIds =
            data.medias.mapIndexed { index, it ->
                uploadMedia(it, st).also {
                    progress(ComposeProgress(index + 1, maxProgress))
                }
            }
        val mediaId = mediaIds.joinToString(",")
        if (data.replyId != null && data.commentId != null) {
            service.replyComment(
                id = data.commentId,
                cid = data.replyId,
                content = data.content,
                st = st,
                picId = mediaId,
            )
        } else if (data.commentId != null) {
            service.commentStatus(
                id = data.commentId,
                content = data.content,
                st = st,
                picId = mediaId,
            )
        } else if (data.repostId != null) {
            service.repostStatus(
                id = data.repostId,
                content = data.content,
                st = st,
                picId = mediaId,
            )
        } else {
            service.updateStatus(
                content = data.content,
                st = st,
                picId = mediaId,
            )
        }
    }

    override suspend fun deleteStatus(statusKey: MicroBlogKey) {
        val config = service.config()
        val st = config.data?.st
        requireNotNull(st) { "st is null" }
        service.deleteStatus(
            mid = statusKey.id,
            st = st,
        )
    }

    override fun searchStatus(
        query: String,
        scope: CoroutineScope,
        pageSize: Int,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> =
        timelinePager(
            pageSize = pageSize,
            pagingKey = pagingKey,
            accountKey = account.accountKey,
            database = database,
            filterFlow = localFilterRepository.getFlow(forSearch = true),
            scope = scope,
            mediator =
                SearchStatusRemoteMediator(
                    service,
                    database,
                    account.accountKey,
                    pagingKey,
                    query,
                ),
        )

    override fun searchUser(
        query: String,
        scope: CoroutineScope,
        pageSize: Int,
    ): Flow<PagingData<UiUser>> =
        Pager(
            config = PagingConfig(pageSize = pageSize),
        ) {
            SearchUserPagingSource(
                service = service,
                accountKey = account.accountKey,
                query = query,
            )
        }.flow

    override fun discoverUsers(pageSize: Int): Flow<PagingData<UiUser>> {
        TODO("Not yet implemented")
    }

    override fun discoverStatuses(
        pageSize: Int,
        scope: CoroutineScope,
        pagingKey: String,
    ): Flow<PagingData<UiStatus>> =
        timelinePager(
            pageSize = pageSize,
            pagingKey = pagingKey,
            accountKey = account.accountKey,
            database = database,
            filterFlow = localFilterRepository.getFlow(forTimeline = true),
            scope = scope,
            mediator =
                DiscoverStatusRemoteMediator(
                    service,
                    database,
                    account.accountKey,
                    pagingKey,
                ),
        )

    override fun discoverHashtags(pageSize: Int): Flow<PagingData<UiHashtag>> =
        Pager(
            config = PagingConfig(pageSize = pageSize),
        ) {
            TrendHashtagPagingSource(
                service,
            )
        }.flow

    override fun composeConfig(statusKey: MicroBlogKey?): ComposeConfig =
        ComposeConfig(
            text = ComposeConfig.Text(2000),
            media = ComposeConfig.Media(if (statusKey == null) 18 else 1, false),
        )

    override suspend fun follow(
        userKey: MicroBlogKey,
        relation: UiRelation,
    ) {
        require(relation is UiRelation.VVO)
        if (relation.following) {
            unfollow(userKey)
        } else {
            follow(userKey)
        }
    }

    override fun profileActions(): List<ProfileAction> = emptyList()

    suspend fun follow(userKey: MicroBlogKey) {
        val key = relationKeyWithUserKey(userKey)
        MemCacheable.updateWith<UiRelation.VVO>(
            key = key,
        ) {
            it.copy(
                following = true,
            )
        }
        runCatching {
            val config = service.config()
            val st = config.data?.st
            requireNotNull(st) { "st is null" }
            service.follow(
                st = st,
                uid = userKey.id,
            )
        }.onFailure {
            MemCacheable.updateWith<UiRelation.VVO>(
                key = key,
            ) {
                it.copy(
                    following = false,
                )
            }
        }
    }

    suspend fun unfollow(userKey: MicroBlogKey) {
        val key = relationKeyWithUserKey(userKey)
        MemCacheable.updateWith<UiRelation.VVO>(
            key = key,
        ) {
            it.copy(
                following = false,
            )
        }
        runCatching {
            val config = service.config()
            val st = config.data?.st
            requireNotNull(st) { "st is null" }
            service.unfollow(
                st = st,
                uid = userKey.id,
            )
        }.onFailure {
            MemCacheable.updateWith<UiRelation.VVO>(
                key = key,
            ) {
                it.copy(
                    following = true,
                )
            }
        }
    }

    fun statusComment(statusKey: MicroBlogKey): Flow<PagingData<UiStatus.VVONotification>> =
        Pager(
            config = PagingConfig(pageSize = 20),
        ) {
            StatusCommentPagingSource(
                service = service,
                accountKey = account.accountKey,
                statusKey = statusKey,
            )
        }.flow

    fun statusRepost(statusKey: MicroBlogKey): Flow<PagingData<UiStatus.VVO>> =
        Pager(
            config = PagingConfig(pageSize = 20),
        ) {
            StatusRepostPagingSource(
                service = service,
                accountKey = account.accountKey,
                statusKey = statusKey,
            )
        }.flow

    fun statusExtendedText(statusKey: MicroBlogKey): Flow<UiState<String>> =
        MemCacheable(
            "status_extended_text_$statusKey",
        ) {
            val config = service.config()
            val st = config.data?.st
            requireNotNull(st) { "st is null" }
            val response = service.getStatusExtend(statusKey.id, st)
            response.data?.longTextContent.orEmpty()
        }.toUi()

    suspend fun like(status: UiStatus.VVO) {
        updateStatusUseCase<StatusContent.VVO>(
            statusKey = status.statusKey,
            accountKey = status.accountKey,
            cacheDatabase = database,
            update = {
                it.copy(
                    data =
                        it.data.copy(
                            favorited = !status.liked,
                            attitudesCount =
                                if (status.liked) {
                                    it.data.attitudesCount?.minus(1)
                                } else {
                                    it.data.attitudesCount?.plus(1)
                                },
                        ),
                )
            },
        )

        runCatching {
            val st = service.config().data?.st
            requireNotNull(st) { "st is null" }
            if (status.liked) {
                service.unlikeStatus(id = status.statusKey.id, st = st)
            } else {
                service.likeStatus(id = status.statusKey.id, st = st)
            }
        }.onFailure {
            updateStatusUseCase<StatusContent.VVO>(
                statusKey = status.statusKey,
                accountKey = status.accountKey,
                cacheDatabase = database,
                update = {
                    it.copy(
                        data =
                            it.data.copy(
                                favorited = status.liked,
                                attitudesCount =
                                    if (status.liked) {
                                        it.data.attitudesCount?.plus(1)
                                    } else {
                                        it.data.attitudesCount?.minus(1)
                                    },
                            ),
                    )
                },
            )
        }.onSuccess {
        }
    }
}
