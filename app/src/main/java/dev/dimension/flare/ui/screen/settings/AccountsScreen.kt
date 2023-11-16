package dev.dimension.flare.ui.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.dimension.flare.R
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.molecule.producePresenter
import dev.dimension.flare.ui.component.AvatarComponent
import dev.dimension.flare.ui.component.HtmlText2
import dev.dimension.flare.ui.component.ThemeWrapper
import dev.dimension.flare.ui.component.placeholder.placeholder
import dev.dimension.flare.ui.model.UiAccount
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.UiUser
import dev.dimension.flare.ui.model.onSuccess
import dev.dimension.flare.ui.presenter.settings.AccountsPresenter
import dev.dimension.flare.ui.screen.destinations.ServiceSelectRouteDestination

@Composable
@Destination(
    wrappers = [ThemeWrapper::class],
)
fun AccountsRoute(navigator: DestinationsNavigator) {
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
    Scaffold(
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
                        AccountItem(
                            userState = accountState.data[index],
                            activeAccount = state.activeAccount,
                            onClick = {
                                state.setActiveAccount(it)
                            },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AccountItem(
    userState: UiState<UiUser>,
    activeAccount: UiState<UiAccount>,
    onClick: (MicroBlogKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (userState) {
        // TODO: show error
        is UiState.Error -> Unit
        is UiState.Loading -> {
            AccountItemLoadingPlaceholder(modifier)
        }

        is UiState.Success -> {
            ListItem(
                headlineContent = {
                    HtmlText2(element = userState.data.nameElement)
                },
                modifier =
                    modifier
                        .clickable {
                            onClick.invoke(userState.data.userKey)
                        },
                leadingContent = {
                    AvatarComponent(data = userState.data.avatarUrl)
                },
                trailingContent = {
                    activeAccount.onSuccess {
                        RadioButton(
                            selected = it.accountKey == userState.data.userKey,
                            onClick = {
                                onClick.invoke(userState.data.userKey)
                            },
                        )
                    }
                },
                supportingContent = {
                    Text(text = userState.data.handle)
                },
            )
        }
    }
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
