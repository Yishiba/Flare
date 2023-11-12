package dev.dimension.flare.ui.screen.login.misskey

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.dimension.flare.R
import dev.dimension.flare.data.repository.ApplicationRepository
import dev.dimension.flare.molecule.producePresenter
import dev.dimension.flare.ui.common.plus
import dev.dimension.flare.ui.component.OutlinedTextField2
import dev.dimension.flare.ui.presenter.login.misskeyLoginUseCase
import dev.dimension.flare.ui.theme.FlareTheme
import dev.dimension.flare.ui.theme.screenHorizontalPadding
import kotlinx.coroutines.launch
import org.koin.compose.rememberKoinInject

@Destination
@Composable
fun MisskeyLoginRoute(navigator: DestinationsNavigator) {
    MisskeyLoginScreen(
        onBack = navigator::navigateUp,
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MisskeyLoginScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
) {
    val uriHandler = LocalUriHandler.current
    val state by producePresenter {
        loginPresenter(
            launchUrl = {
                uriHandler.openUri(it)
            },
        )
    }
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    FlareTheme {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onBack,
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(id = R.string.navigate_back),
                            )
                        }
                    },
                )
            },
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(it + PaddingValues(horizontal = screenHorizontalPadding)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .weight(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                ) {
                    Text(
                        text = stringResource(id = R.string.misskey_login_title),
                        style = MaterialTheme.typography.headlineMedium,
                    )
                    Text(
                        text = stringResource(id = R.string.misskey_login_message),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                    )
                }
                Column(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .weight(2f)
                            .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    OutlinedTextField2(
                        state = state.hostTextState,
                        label = {
                            Text(text = stringResource(id = R.string.misskey_login_hint))
                        },
                        enabled = !state.loading,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .focusRequester(
                                    focusRequester = focusRequester,
                                ),
                        lineLimits = TextFieldLineLimits.SingleLine,
                    )
                    Button(
                        onClick = state::login,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = stringResource(id = R.string.login_button))
                    }
                    state.error?.let { error ->
                        Text(text = error)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun loginPresenter(launchUrl: (String) -> Unit) =
    run {
        val applicationRepository: ApplicationRepository = rememberKoinInject()
        val hostTextState by remember {
            mutableStateOf(TextFieldState(""))
        }
        var loading by remember { mutableStateOf(false) }
        var error by remember { mutableStateOf<String?>(null) }
        val scope = rememberCoroutineScope()
        object {
            val hostTextState = hostTextState
            val loading = loading
            val error = error

            fun login() {
                scope.launch {
                    loading = true
                    error = null
                    misskeyLoginUseCase(
                        host = hostTextState.text.toString(),
                        applicationRepository = applicationRepository,
                        launchOAuth = launchUrl,
                    ).onFailure {
                        error = it.message
                    }
                    loading = false
                }
            }
        }
    }
