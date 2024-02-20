package dev.dimension.flare.ui.presenter.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.dimension.flare.common.LazyPagingItemsProxy
import dev.dimension.flare.common.collectPagingProxy
import dev.dimension.flare.data.repository.accountServiceProvider
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.ui.model.UiHashtag
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.UiUser
import dev.dimension.flare.ui.model.flatMap
import dev.dimension.flare.ui.presenter.PresenterBase

class DiscoverPresenter(
    private val accountKey: MicroBlogKey,
) : PresenterBase<DiscoverState>() {
    @Composable
    override fun body(): DiscoverState {
        val accountState = accountServiceProvider(accountKey = accountKey)
        val users =
            accountState.flatMap { dataSource ->
                remember(accountKey) {
                    runCatching {
                        dataSource.discoverUsers()
                    }.getOrNull()
                }?.collectPagingProxy().let {
                    if (it == null) {
                        UiState.Error(Throwable("No data"))
                    } else {
                        UiState.Success(it)
                    }
                }
            }
        val status =
            accountState.flatMap { dataSource ->
                remember(accountKey) {
                    runCatching {
                        dataSource.discoverStatuses()
                    }.getOrNull()
                }?.collectPagingProxy().let {
                    if (it == null) {
                        UiState.Error(Throwable("No data"))
                    } else {
                        UiState.Success(it)
                    }
                }
            }
        val hashtags =
            accountState.flatMap { dataSource ->
                remember(accountKey) {
                    runCatching {
                        dataSource.discoverHashtags()
                    }.getOrNull()
                }?.collectPagingProxy().let {
                    if (it == null) {
                        UiState.Error(Throwable("No data"))
                    } else {
                        UiState.Success(it)
                    }
                }
            }

        return object : DiscoverState {
            override val users = users
            override val status = status
            override val hashtags = hashtags
        }
    }
}

interface DiscoverState {
    val users: UiState<LazyPagingItemsProxy<UiUser>>
    val status: UiState<LazyPagingItemsProxy<UiStatus>>
    val hashtags: UiState<LazyPagingItemsProxy<UiHashtag>>
}
