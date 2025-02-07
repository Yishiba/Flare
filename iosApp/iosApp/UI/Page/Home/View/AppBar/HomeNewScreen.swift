import shared
import SwiftUI

struct HomeNewScreen: View {
    let accountType: AccountType
    @StateObject private var timelineStore: TimelineStore
    @StateObject private var tabStore: TabSettingsStore
    @StateObject private var appState: FLNewAppState
    @State private var isShowAppBar: Bool? = true
    @State private var showSettings = false
    @State private var showTabSettings = false
    @State private var showLogin = false

    init(accountType: AccountType) {
        self.accountType = accountType

        // 1. 先初始化 TimelineStore
        let timelineStore = TimelineStore(accountType: accountType)
        _timelineStore = StateObject(wrappedValue: timelineStore)

        // 2. 初始化 TabSettingsStore
        let tabStore = TabSettingsStore(timelineStore: timelineStore, accountType: accountType)
        _tabStore = StateObject(wrappedValue: tabStore)

        // 3. 初始化 AppState
        let appState = FLNewAppState(tabStore: tabStore)
        _appState = StateObject(wrappedValue: appState)

        // 4. 游客模式特殊处理
        if accountType is AccountTypeGuest {
            // 设置默认的 Home Timeline
            timelineStore.currentPresenter = HomeTimelinePresenter(accountType: accountType)

            // 只使用 Home 标签
            let homeTab = FLHomeTimelineTabItem(
                metaData: FLTabMetaData(
                    title: .localized(.home),
                    icon: .material(.home)
                ), account: accountType
            )
            tabStore.availableTabs = [homeTab]
            tabStore.updateSelectedTab(homeTab)
        }
    }

    var body: some View {
        // 游客模式或者用户数据已加载时显示内容
        if accountType is AccountTypeGuest || tabStore.currentUser != nil {
            FLNewSideMenu(
                isOpen: $appState.isMenuOpen,
                menu: FLNewMenuView(isOpen: $appState.isMenuOpen),
                content: HomeNewViewControllerRepresentable(
                    tabStore: tabStore,
                    timelineStore: timelineStore,
                    accountType: accountType,
                    selectedTab: $appState.currentTab,
                    isShowAppBar: $isShowAppBar
                )
                .newMenuGesture(appState: appState)
            )
            .onAppear {
                // 添加通知监听
                NotificationCenter.default.addObserver(
                    forName: .flShowNewMenu,
                    object: nil,
                    queue: .main
                ) { [appState] _ in
                    withAnimation {
                        appState.isMenuOpen = true
                    }
                }

                NotificationCenter.default.addObserver(
                    forName: NSNotification.Name("ShowSettings"),
                    object: nil,
                    queue: .main
                ) { _ in
                    showSettings = true
                }

                NotificationCenter.default.addObserver(
                    forName: NSNotification.Name("ShowTabSettings"),
                    object: nil,
                    queue: .main
                ) { _ in
                    showTabSettings = true
                }

                NotificationCenter.default.addObserver(
                    forName: NSNotification.Name("ShowLogin"),
                    object: nil,
                    queue: .main
                ) { _ in
                    showLogin = true
                }
            }
            .sheet(isPresented: $showSettings) {
                SettingsScreen()
            }
            .sheet(isPresented: $showTabSettings) {
                HomeAppBarSettingsView(store: tabStore)
            }
            .sheet(isPresented: $showLogin) {
                ServiceSelectScreen(toHome: {
                    showLogin = false
                })
            }
        } else {
            // 显示加载状态
            ProgressView()
                .frame(maxWidth: .infinity, maxHeight: .infinity)
        }
    }
}

// - HomeNewViewControllerRepresentable

struct HomeNewViewControllerRepresentable: UIViewControllerRepresentable {
    let tabStore: TabSettingsStore
    let timelineStore: TimelineStore
    let accountType: AccountType
    @Binding var selectedTab: Int
    @Binding var isShowAppBar: Bool?

    func makeUIViewController(context _: Context) -> HomeNewViewController {
        let controller = HomeNewViewController(
            tabStore: tabStore,
            timelineStore: timelineStore,
            accountType: accountType
        )
        return controller
    }

    func updateUIViewController(_ uiViewController: HomeNewViewController, context _: Context) {
        // 更新选中的标签页
        uiViewController.updateSelectedTab(selectedTab)
        // 更新 AppBar 的可见性
        uiViewController.updateAppBarVisibility(isShowAppBar)
    }
}
