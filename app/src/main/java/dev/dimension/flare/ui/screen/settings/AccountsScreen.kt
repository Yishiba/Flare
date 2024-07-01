package dev.dimension.flare.ui.screen.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoodBad
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eygraber.compose.placeholder.material3.placeholder
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.destinations.ServiceSelectRouteDestination
import dev.dimension.flare.R
import dev.dimension.flare.data.repository.LoginExpiredException
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.molecule.producePresenter
import dev.dimension.flare.ui.component.AvatarComponent
import dev.dimension.flare.ui.component.AvatarComponentDefaults
import dev.dimension.flare.ui.component.FlareScaffold
import dev.dimension.flare.ui.component.HtmlText
import dev.dimension.flare.ui.component.ThemeWrapper
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.UiUser
import dev.dimension.flare.ui.model.isError
import dev.dimension.flare.ui.model.isSuccess
import dev.dimension.flare.ui.model.onError
import dev.dimension.flare.ui.model.onLoading
import dev.dimension.flare.ui.model.onSuccess
import dev.dimension.flare.ui.presenter.invoke
import dev.dimension.flare.ui.presenter.settings.AccountsPresenter

@Composable
@Destination<RootGraph>(
    wrappers = [ThemeWrapper::class],
)
internal fun AccountsRoute(navigator: ProxyDestinationsNavigator) {
    AccountsScreen(
        onBack = navigator::navigateUp,
        toLogin = {
            navigator.navigate(ServiceSelectRouteDestination)
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AccountsScreen(
    onBack: () -> Unit,
    toLogin: () -> Unit,
) {
    val state by producePresenter {
        accountsPresenter()
    }
    FlareScaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.settings_accounts_title))
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_back),
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            toLogin.invoke()
                        },
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                },
            )
        },
    ) {
        LazyColumn(
            contentPadding = it,
        ) {
            when (val accountState = state.accounts) {
                // TODO: show error
                is UiState.Error -> Unit
                is UiState.Loading -> {
                    items(3) {
                        AccountItemLoadingPlaceholder()
                    }
                }

                is UiState.Success -> {
                    items(accountState.data.size) { index ->
                        val (accountKey, data) = accountState.data[index]
                        SwipeToDismissBox(
                            state =
                                rememberSwipeToDismissBoxState(
                                    confirmValueChange = {
                                        if (it == SwipeToDismissBoxValue.EndToStart) {
                                            state.removeAccount(accountKey)
                                            true
                                        } else {
                                            false
                                        }
                                    },
                                ),
                            backgroundContent = {
                                Box(
                                    modifier =
                                        Modifier
                                            .fillMaxSize()
                                            .background(color = MaterialTheme.colorScheme.error)
                                            .padding(16.dp),
                                    contentAlignment = Alignment.CenterEnd,
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.settings_accounts_remove),
                                        color = MaterialTheme.colorScheme.onError,
                                    )
                                }
                            },
                            enableDismissFromStartToEnd = false,
                            enableDismissFromEndToStart = data.isSuccess || data.isError,
                        ) {
                            AccountItem(
                                modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                                userState = data,
                                onClick = {
                                    state.setActiveAccount(it)
                                },
                                toLogin = toLogin,
                                trailingContent = { user ->
                                    state.activeAccount.onSuccess {
                                        RadioButton(
                                            selected = it.accountKey == user.userKey,
                                            onClick = {
                                                state.setActiveAccount(user.userKey)
                                            },
                                        )
                                    }
                                },
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AccountItem(
    userState: UiState<UiUser>,
    onClick: (MicroBlogKey) -> Unit,
    toLogin: () -> Unit,
    modifier: Modifier = Modifier,
    trailingContent: @Composable (UiUser) -> Unit = { },
    headlineContent: @Composable (UiUser) -> Unit = {
        HtmlText(element = it.nameElement, maxLines = 1)
    },
    supportingContent: @Composable (UiUser) -> Unit = {
        Text(text = it.handle, maxLines = 1)
    },
) {
    userState
        .onSuccess { data ->
            ListItem(
                headlineContent = {
                    headlineContent.invoke(data)
                },
                modifier =
                    modifier
                        .clickable {
                            onClick.invoke(data.userKey)
                        },
                leadingContent = {
                    AvatarComponent(data = data.avatarUrl)
                },
                trailingContent = {
                    trailingContent.invoke(data)
                },
                supportingContent = {
                    supportingContent.invoke(data)
                },
                colors = ListItemDefaults.colors(containerColor = Color.Transparent),
            )
        }.onLoading {
            AccountItemLoadingPlaceholder(modifier)
        }.onError {
            AccountItemError(it, toLogin, modifier)
        }
}

@Composable
private fun AccountItemError(
    throwable: Throwable,
    toLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = {
            if (throwable is LoginExpiredException) {
                Text(text = stringResource(id = R.string.login_expired))
            } else {
                Text(text = stringResource(id = R.string.account_item_error_title))
            }
        },
        modifier = modifier,
        leadingContent = {
            Icon(
                Icons.Default.MoodBad,
                contentDescription = stringResource(id = R.string.account_item_error_title),
                modifier = Modifier.size(AvatarComponentDefaults.size),
            )
        },
        supportingContent = {
            if (throwable is LoginExpiredException) {
                Text(text = stringResource(id = R.string.login_expired_message))
            } else {
                Text(text = stringResource(id = R.string.account_item_error_message))
            }
        },
        trailingContent =
            if (throwable is LoginExpiredException) {
                {
                    TextButton(onClick = toLogin) {
                        Text(text = stringResource(id = R.string.login_expired_relogin))
                    }
                }
            } else {
                null
            },
    )
}

@Composable
private fun AccountItemLoadingPlaceholder(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = {
            Text(text = "Loading...", modifier = Modifier.placeholder(true))
        },
        modifier = modifier,
        leadingContent = {
            AvatarComponent(data = null, modifier = Modifier.placeholder(true, shape = CircleShape))
        },
        supportingContent = {
            Text(text = "Loading...", modifier = Modifier.placeholder(true))
        },
    )
}

@Composable
private fun accountsPresenter() =
    run {
        remember {
            AccountsPresenter()
        }.invoke()
    }
