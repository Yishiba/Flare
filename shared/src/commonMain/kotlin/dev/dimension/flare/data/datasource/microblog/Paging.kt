package dev.dimension.flare.data.datasource.microblog

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.RemoteMediator
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import app.cash.sqldelight.paging3.QueryPagingSource
import dev.dimension.flare.data.cache.DbPagingTimelineWithStatusView
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.mapper.toUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

@OptIn(ExperimentalPagingApi::class)
internal fun timelinePager(
    pageSize: Int,
    pagingKey: String,
    accountKey: MicroBlogKey,
    database: CacheDatabase,
    scope: CoroutineScope,
    filterFlow: Flow<List<String>>,
    mediator: RemoteMediator<Int, DbPagingTimelineWithStatusView>,
): Flow<PagingData<UiStatus>> {
    val pagerFlow =
        Pager(
            config = PagingConfig(pageSize = pageSize),
            remoteMediator = mediator,
            pagingSourceFactory = {
                QueryPagingSource(
                    countQuery =
                        database.dbPagingTimelineQueries.pageCount(
                            account_key = accountKey,
                            paging_key = pagingKey,
                        ),
                    transacter = database.dbPagingTimelineQueries,
                    context = Dispatchers.IO,
                    queryProvider = { limit, offset ->
                        database.dbPagingTimelineQueries.getPage(
                            account_key = accountKey,
                            paging_key = pagingKey,
                            offset = offset,
                            limit = limit,
                        )
                    },
                )
            },
        ).flow.cachedIn(scope)
    return combine(pagerFlow, filterFlow) { pagingData, filters ->
        pagingData
            .map {
                it.toUi()
            }
            .filter {
                !it.contains(filters)
            }
    }.cachedIn(scope)
}

private fun UiStatus.contains(keywords: List<String>): Boolean {
    val text = textToFilter
    return keywords.any { keyword ->
        text.any { it.contains(keyword, ignoreCase = true) }
    }
}

private val UiStatus.textToFilter: List<String>
    get() = textToFilter(mutableSetOf())

private fun UiStatus.textToFilter(visited: MutableSet<UiStatus>): List<String> {
    // avoid infinite loop
    if (!visited.add(this)) {
        return emptyList()
    }

    return when (this) {
        is UiStatus.Bluesky -> listOfNotNull(content) + (quote?.textToFilter(visited).orEmpty())
        is UiStatus.BlueskyNotification -> emptyList()
        is UiStatus.Mastodon ->
            listOfNotNull(content, contentWarningText) +
                (reblogStatus?.textToFilter(visited).orEmpty())
        is UiStatus.MastodonNotification ->
            listOfNotNull(status?.content, status?.contentWarningText) +
                (status?.reblogStatus?.textToFilter(visited).orEmpty())
        is UiStatus.Misskey ->
            listOfNotNull(content, contentWarningText) +
                (quote?.textToFilter(visited).orEmpty()) +
                (renote?.textToFilter(visited).orEmpty())
        is UiStatus.MisskeyNotification ->
            listOfNotNull(note?.content, note?.contentWarningText) +
                (note?.quote?.textToFilter(visited).orEmpty()) +
                (note?.renote?.textToFilter(visited).orEmpty())
        is UiStatus.XQT ->
            listOfNotNull(content) + (quote?.textToFilter(visited).orEmpty()) +
                (retweet?.textToFilter(visited).orEmpty())

        is UiStatus.XQTNotification -> emptyList()

        is UiStatus.VVO -> listOfNotNull(content) + (quote?.textToFilter(visited).orEmpty())

        is UiStatus.VVONotification -> emptyList()
    }
}
