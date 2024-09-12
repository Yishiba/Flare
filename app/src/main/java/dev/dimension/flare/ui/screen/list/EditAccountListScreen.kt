package dev.dimension.flare.ui.screen.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.eygraber.compose.placeholder.material3.placeholder
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.dimension.flare.R
import dev.dimension.flare.model.AccountType
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.molecule.producePresenter
import dev.dimension.flare.ui.component.FlareScaffold
import dev.dimension.flare.ui.model.onLoading
import dev.dimension.flare.ui.model.onSuccess
import dev.dimension.flare.ui.presenter.invoke
import dev.dimension.flare.ui.presenter.list.EditAccountListPresenter

@Destination<RootGraph>
@Composable
internal fun EditAccountListRoute(
    navigator: DestinationsNavigator,
    accountType: AccountType,
    userKey: MicroBlogKey,
) {
    EditAccountListScreen(
        accountType = accountType,
        userKey = userKey,
        onBack = navigator::navigateUp,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditAccountListScreen(
    accountType: AccountType,
    userKey: MicroBlogKey,
    onBack: () -> Unit,
) {
    val state by producePresenter {
        presenter(
            accountType = accountType,
            userKey = userKey,
        )
    }
    FlareScaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.edit_account_list_title))
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.navigate_back),
                        )
                    }
                },
            )
        },
        content = { contentPadding ->
            LazyColumn(
                contentPadding = contentPadding,
            ) {
                listItemComponent(
                    state.lists,
                ) { item ->
                    state.userLists
                        .onSuccess {
                            if (it.any { list -> list.id == item.id }) {
                                IconButton(
                                    onClick = { state.removeList(item) },
                                ) {
                                    Icon(
                                        Icons.Default.Delete,
                                        contentDescription = stringResource(id = R.string.edit_list_member_remove),
                                        tint = MaterialTheme.colorScheme.error,
                                    )
                                }
                            } else {
                                IconButton(
                                    onClick = { state.addList(item) },
                                ) {
                                    Icon(
                                        Icons.Default.Add,
                                        contentDescription = stringResource(id = R.string.edit_list_member_add),
                                    )
                                }
                            }
                        }.onLoading {
                            IconButton(
                                onClick = {
                                },
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = stringResource(id = R.string.edit_list_member_add),
                                    modifier = Modifier.placeholder(true),
                                )
                            }
                        }
                }
            }
        },
    )
}

@Composable
private fun presenter(
    accountType: AccountType,
    userKey: MicroBlogKey,
) = run {
    remember("EditAccountListPresenter_${accountType}_$userKey") {
        EditAccountListPresenter(
            accountType = accountType,
            userKey = userKey,
        )
    }.invoke()
}
