package dev.dimension.flare.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.ComposeRouteDestination
import com.ramcosta.composedestinations.generated.destinations.ServiceSelectRouteDestination
import com.ramcosta.composedestinations.generated.destinations.TabSettingRouteDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.AnglesUp
import compose.icons.fontawesomeicons.solid.Pen
import compose.icons.fontawesomeicons.solid.Sliders
import dev.dimension.flare.R
import dev.dimension.flare.common.PagingState
import dev.dimension.flare.common.isRefreshing
import dev.dimension.flare.common.onSuccess
import dev.dimension.flare.data.model.HomeTimelineTabItem
import dev.dimension.flare.data.model.TimelineTabItem
import dev.dimension.flare.data.repository.SettingsRepository
import dev.dimension.flare.model.AccountType
import dev.dimension.flare.molecule.producePresenter
import dev.dimension.flare.ui.component.AvatarComponent
import dev.dimension.flare.ui.component.FAIcon
import dev.dimension.flare.ui.component.FlareScaffold
import dev.dimension.flare.ui.component.FlareTopAppBar
import dev.dimension.flare.ui.component.LocalBottomBarHeight
import dev.dimension.flare.ui.component.RefreshContainer
import dev.dimension.flare.ui.component.ThemeWrapper
import dev.dimension.flare.ui.component.status.LazyStatusVerticalStaggeredGrid
import dev.dimension.flare.ui.component.status.status
import dev.dimension.flare.ui.model.UiTimeline
import dev.dimension.flare.ui.model.collectAsUiState
import dev.dimension.flare.ui.model.flatMap
import dev.dimension.flare.ui.model.map
import dev.dimension.flare.ui.model.onError
import dev.dimension.flare.ui.model.onSuccess
import dev.dimension.flare.ui.presenter.home.UserPresenter
import dev.dimension.flare.ui.presenter.home.UserState
import dev.dimension.flare.ui.presenter.invoke
import dev.dimension.flare.ui.screen.settings.TabTitle
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Destination<RootGraph>(
    wrappers = [ThemeWrapper::class],
)
@Composable
internal fun HomeTimelineRoute(
    navigator: DestinationsNavigator,
    drawerState: DrawerState,
    accountType: AccountType,
) {
    val scope = rememberCoroutineScope()
    HomeTimelineScreen(
        accountType = accountType,
        toCompose = {
            navigator.navigate(ComposeRouteDestination(accountType = accountType))
        },
        toQuickMenu = {
            scope.launch {
                drawerState.open()
            }
        },
        toLogin = {
            navigator.navigate(ServiceSelectRouteDestination)
        },
        toTabSettings = {
            navigator.navigate(TabSettingRouteDestination(accountType))
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTimelineScreen(
    accountType: AccountType,
    toCompose: () -> Unit,
    toQuickMenu: () -> Unit,
    toLogin: () -> Unit,
    toTabSettings: () -> Unit,
) {
    val state by producePresenter(key = "home_timeline_$accountType") {
        timelinePresenter(accountType)
    }
    val scope = rememberCoroutineScope()
    state.pagerState.onSuccess { pagerState ->
        state.tabState.onSuccess { tabState ->
            val lazyListState = tabState[pagerState.currentPage].lazyListState
            RegisterTabCallback(lazyListState = lazyListState)
        }
    }

    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    FlareScaffold(
        topBar = {
            FlareTopAppBar(
                title = {
                    state.pagerState.onSuccess { pagerState ->
                        state.tabState.onSuccess { tabs ->
                            if (tabs.size > 1) {
                                SecondaryScrollableTabRow(
                                    selectedTabIndex = pagerState.currentPage,
                                    edgePadding = 0.dp,
                                    divider = {},
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    state.tabState.onSuccess { tabs ->
                                        tabs.forEachIndexed { index, tab ->
                                            Tab(
                                                selected = index == pagerState.currentPage,
                                                onClick = {
                                                    scope.launch {
                                                        pagerState.scrollToPage(index)
                                                    }
                                                },
                                            ) {
                                                TabTitle(
                                                    tab.timelineTabItem.metaData.title,
                                                    modifier =
                                                        Modifier
                                                            .padding(8.dp),
                                                )
                                            }
                                        }
                                    }
                                }
                            } else {
                                TabTitle(title = tabs[0].timelineTabItem.metaData.title)
                            }
                        }
                    }
                },
                scrollBehavior = topAppBarScrollBehavior,
                navigationIcon = {
                    if (LocalBottomBarHeight.current != 0.dp) {
                        state.user.onSuccess {
                            IconButton(
                                onClick = toQuickMenu,
                            ) {
                                AvatarComponent(it.avatar, size = 24.dp)
                            }
                        }
                    }
                },
                actions = {
                    state.user
                        .onError {
                            TextButton(onClick = toLogin) {
                                Text(text = stringResource(id = R.string.login_button))
                            }
                        }.onSuccess {
                            IconButton(
                                onClick = toTabSettings,
                            ) {
                                FAIcon(
                                    FontAwesomeIcons.Solid.Sliders,
                                    contentDescription = null,
                                )
                            }
                        }
                },
            )
        },
        floatingActionButton = {
            state.user.onSuccess {
                AnimatedVisibility(
                    visible = topAppBarScrollBehavior.state.heightOffset == 0f && LocalBottomBarHeight.current != 0.dp,
                    enter = scaleIn(),
                    exit = scaleOut(),
                ) {
                    FloatingActionButton(
                        onClick = toCompose,
                    ) {
                        FAIcon(
                            imageVector = FontAwesomeIcons.Solid.Pen,
                            contentDescription = stringResource(id = R.string.compose_title),
                        )
                    }
                }
            }
        },
        modifier = Modifier.nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
    ) { contentPadding ->
        state.pagerState.onSuccess { pagerState ->
            state.tabState.onSuccess { tabs ->
                if (tabs.size == 1) {
                    // workaround for a bug in HorizontalPager with Drawer
                    // https://issuetracker.google.com/issues/167408603
                    TimelineItemContent(
                        state = tabs[0],
                        contentPadding = contentPadding,
                        modifier = Modifier.fillMaxWidth(),
                    )
                } else {
                    HorizontalPager(
                        state = pagerState,
                    ) { index ->
                        val tab = tabs[index]
                        TimelineItemContent(
                            state = tab,
                            contentPadding = contentPadding,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
internal fun TimelineItemContent(
    state: TimelineItemState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val scope = rememberCoroutineScope()
    RefreshContainer(
        modifier = modifier,
        onRefresh = state::refreshSync,
        isRefreshing = state.isRefreshing,
        indicatorPadding = contentPadding,
        content = {
            LazyStatusVerticalStaggeredGrid(
                state = state.lazyListState,
                contentPadding = contentPadding,
                modifier = Modifier.fillMaxSize(),
            ) {
                status(state.listState)
            }
            state.listState.onSuccess {
                AnimatedVisibility(
                    state.showNewToots,
                    enter = slideInVertically { -it },
                    exit = slideOutVertically { -it },
                    modifier =
                        Modifier
                            .padding(contentPadding)
                            .align(Alignment.TopCenter),
                ) {
                    FilledTonalButton(
                        onClick = {
                            state.onNewTootsShown()
                            scope.launch {
                                state.lazyListState.scrollToItem(0)
                            }
                        },
                    ) {
                        FAIcon(
                            imageVector = FontAwesomeIcons.Solid.AnglesUp,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = stringResource(id = R.string.home_timeline_new_toots))
                    }
                }
            }
        },
    )
}

@Composable
private fun timelinePresenter(
    accountType: AccountType,
    settingsRepository: SettingsRepository = koinInject(),
) = run {
    val accountState =
        remember(accountType) {
            UserPresenter(
                accountType = accountType,
                userKey = null,
            )
        }.invoke()
    val tabSettings by settingsRepository.tabSettings.collectAsUiState()
    val tabs =
        remember(accountType, accountState, tabSettings) {
            accountState.user.flatMap { user ->
                tabSettings.map {
                    it.homeTabs.getOrDefault(
                        user.key,
                        listOf(HomeTimelineTabItem(accountType = AccountType.Specific(user.key))),
                    )
                }
            }
        }
    val pagerState =
        tabs.map {
            rememberPagerState { it.size }
        }
    val tabState =
        tabs.map {
            it
                .map {
                    timelineItemPresenter(it)
                }.toImmutableList()
        }

    object : UserState by accountState {
        val pagerState = pagerState
        val tabState = tabState
    }
}

@Composable
internal fun timelineItemPresenter(timelineTabItem: TimelineTabItem): TimelineItemState {
    val timelinePresenter =
        remember(timelineTabItem) {
            timelineTabItem.createPresenter()
        }
    val scope = rememberCoroutineScope()
    val state = timelinePresenter()
    var showNewToots by remember { mutableStateOf(false) }
    state.listState.onSuccess {
        LaunchedEffect(Unit) {
            snapshotFlow {
                if (itemCount > 0) {
                    peek(0)?.itemKey
                } else {
                    null
                }
            }.mapNotNull { it }
                .distinctUntilChanged()
                .drop(1)
                .collect {
                    showNewToots = true
                }
        }
    }
    val lazyListState = rememberLazyStaggeredGridState()
    val isAtTheTop by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex == 0
        }
    }
    LaunchedEffect(isAtTheTop, showNewToots) {
        if (isAtTheTop) {
            showNewToots = false
        }
    }
    return object : TimelineItemState {
        override val listState = state.listState
        override val showNewToots = showNewToots
        override val isRefreshing = state.listState.isRefreshing
        override val lazyListState = lazyListState
        override val timelineTabItem = timelineTabItem

        override fun onNewTootsShown() {
            showNewToots = false
        }

        override fun refreshSync() {
            scope.launch {
                state.refresh()
            }
        }
    }
}

@Immutable
internal interface TimelineItemState {
    val listState: PagingState<UiTimeline>
    val showNewToots: Boolean
    val isRefreshing: Boolean
    val lazyListState: LazyStaggeredGridState
    val timelineTabItem: TimelineTabItem

    fun onNewTootsShown()

    fun refreshSync()
}
