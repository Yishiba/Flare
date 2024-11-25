package dev.dimension.flare.ui.presenter.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import dev.dimension.flare.data.repository.LocalFilterRepository
import dev.dimension.flare.ui.model.UiKeywordFilter
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.collectAsUiState
import dev.dimension.flare.ui.presenter.PresenterBase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalFilterPresenter :
    PresenterBase<LocalFilterState>(),
    KoinComponent {
    private val repository by inject<LocalFilterRepository>()

    @Composable
    override fun body(): LocalFilterState {
        val all by remember { repository.getAllFlow() }.collectAsUiState()
        return object : LocalFilterState {
            override val items = all

            override fun add(item: UiKeywordFilter) {
                repository.add(
                    keyword = item.keyword,
                    forTimeline = item.forTimeline,
                    forNotification = item.forNotification,
                    forSearch = item.forSearch,
                    expiredAt = item.expiredAt,
                )
            }

            override fun delete(keyword: String) {
                repository.delete(keyword)
            }

            override fun update(item: UiKeywordFilter) {
                repository.update(
                    keyword = item.keyword,
                    forTimeline = item.forTimeline,
                    forNotification = item.forNotification,
                    forSearch = item.forSearch,
                    expiredAt = item.expiredAt,
                )
            }
        }
    }
}

interface LocalFilterState {
    val items: UiState<ImmutableListWrapper<UiKeywordFilter>>

    fun delete(keyword: String)

    fun add(item: UiKeywordFilter)

    fun update(item: UiKeywordFilter)
}
