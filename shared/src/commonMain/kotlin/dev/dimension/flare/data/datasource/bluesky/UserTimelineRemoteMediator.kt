package dev.dimension.flare.data.datasource.bluesky

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import app.bsky.feed.GetAuthorFeedFilter
import app.bsky.feed.GetAuthorFeedQueryParams
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.database.cache.mapper.Bluesky
import dev.dimension.flare.data.database.cache.model.DbPagingTimelineView
import dev.dimension.flare.data.network.bluesky.BlueskyService
import dev.dimension.flare.model.MicroBlogKey
import sh.christian.ozone.api.Did

@OptIn(ExperimentalPagingApi::class)
internal class UserTimelineRemoteMediator(
    private val service: BlueskyService,
    private val accountKey: MicroBlogKey,
    private val database: CacheDatabase,
    private val userKey: MicroBlogKey,
    private val pagingKey: String,
    private val onlyMedia: Boolean,
) : RemoteMediator<Int, DbPagingTimelineView>() {
    var cursor: String? = null

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DbPagingTimelineView>,
    ): MediatorResult {
        return try {
            val response =
                when (loadType) {
                    LoadType.REFRESH ->
                        service
                            .getAuthorFeed(
                                GetAuthorFeedQueryParams(
                                    limit = state.config.pageSize.toLong(),
                                    actor = Did(did = userKey.id),
                                    filter =
                                        if (onlyMedia) {
                                            GetAuthorFeedFilter.POSTS_WITH_MEDIA
                                        } else {
                                            null
                                        },
                                ),
                            ).maybeResponse()

                    LoadType.PREPEND -> {
                        return MediatorResult.Success(
                            endOfPaginationReached = true,
                        )
                    }

                    LoadType.APPEND -> {
                        service
                            .getAuthorFeed(
                                GetAuthorFeedQueryParams(
                                    limit = state.config.pageSize.toLong(),
                                    cursor = cursor,
                                    actor = Did(did = userKey.id),
                                    filter =
                                        if (onlyMedia) {
                                            GetAuthorFeedFilter.POSTS_WITH_MEDIA
                                        } else {
                                            null
                                        },
                                ),
                            ).maybeResponse()
                    }
                } ?: return MediatorResult.Success(
                    endOfPaginationReached = true,
                )

            cursor = response.cursor
            Bluesky.saveFeed(
                accountKey,
                pagingKey,
                database,
                response.feed,
            )

            MediatorResult.Success(
                endOfPaginationReached = cursor == null,
            )
        } catch (e: Throwable) {
            MediatorResult.Error(e)
        }
    }
}
