package dev.dimension.flare.data.datasource.misskey

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.paging.map
import coil.network.HttpException
import com.moriatsushi.koject.compose.rememberInject
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.database.cache.mapper.saveNotification
import dev.dimension.flare.data.database.cache.model.DbPagingTimelineWithStatus
import dev.dimension.flare.data.repository.app.UiAccount
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.mapper.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
internal class NotificationRemoteMediator(
    private val account: UiAccount.Misskey,
    private val database: CacheDatabase,
    private val pagingKey: String
) : RemoteMediator<Int, DbPagingTimelineWithStatus>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DbPagingTimelineWithStatus>
    ): MediatorResult {
        val service = account.service
        return try {
            val response = when (loadType) {
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.REFRESH -> {
                    service.notifications(
                        count = state.config.pageSize
                    )
                }

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    service.notifications(
                        count = state.config.pageSize,
                        until_id = lastItem.status.status.data.statusKey.id
                    )
                }
            } ?: return MediatorResult.Success(
                endOfPaginationReached = true
            )
            if (loadType == LoadType.REFRESH) {
                database.pagingTimelineDao().delete(pagingKey, account.accountKey)
            }
            with(database) {
                with(response) {
                    saveNotification(account.accountKey, pagingKey)
                }
            }

            MediatorResult.Success(
                endOfPaginationReached = response.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}

@OptIn(ExperimentalPagingApi::class)
@Composable
internal fun notificationDataSource(
    account: UiAccount.Misskey,
    pageSize: Int = 20,
    pagingKey: String = "notification",
    database: CacheDatabase = rememberInject()
): Flow<PagingData<UiStatus>> {
    return remember(
        account.accountKey
    ) {
        Pager(
            config = PagingConfig(pageSize = pageSize),
            remoteMediator = NotificationRemoteMediator(
                account,
                database,
                pagingKey
            )
        ) {
            database.pagingTimelineDao().getPagingSource(pagingKey, account.accountKey)
        }.flow.map {
            it.map {
                it.toUi()
            }
        }
    }
}
