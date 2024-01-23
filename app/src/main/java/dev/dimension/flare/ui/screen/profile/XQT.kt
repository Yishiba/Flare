package dev.dimension.flare.ui.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.dimension.flare.R
import dev.dimension.flare.ui.component.HtmlText2
import dev.dimension.flare.ui.component.MatricesDisplay
import dev.dimension.flare.ui.component.UserFields
import dev.dimension.flare.ui.component.placeholder.placeholder
import dev.dimension.flare.ui.model.UiRelation
import dev.dimension.flare.ui.model.UiState
import dev.dimension.flare.ui.model.UiUser
import dev.dimension.flare.ui.model.descriptionDirection
import dev.dimension.flare.ui.model.onSuccess
import dev.dimension.flare.ui.theme.MediumAlpha
import dev.dimension.flare.ui.theme.screenHorizontalPadding
import kotlinx.collections.immutable.persistentMapOf

@Composable
internal fun XQTProfileHeader(
    user: UiUser.XQT,
    relationState: UiState<UiRelation>,
    onFollowClick: (UiRelation.XQT) -> Unit,
    isMe: UiState<Boolean>,
    menu: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    expandMatrices: Boolean = false,
) {
    CommonProfileHeader(
        bannerUrl = user.bannerUrl,
        avatarUrl = user.avatarUrl,
        displayName = user.nameElement,
        handle = user.handle,
        handleTrailing = {
            when (user.verifyType) {
                UiUser.XQT.VerifyType.Money ->
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        modifier =
                            Modifier
                                .size(12.dp)
                                .alpha(MediumAlpha),
                        tint = Color.Blue,
                    )
                UiUser.XQT.VerifyType.Company ->
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        modifier =
                            Modifier
                                .size(12.dp)
                                .alpha(MediumAlpha),
                        tint = Color.Yellow,
                    )
                null -> Unit
            }
        },
        headerTrailing = {
            isMe.onSuccess {
                if (!it) {
                    when (relationState) {
                        is UiState.Error -> Unit
                        is UiState.Loading -> {
                            FilledTonalButton(
                                onClick = {
                                    // No-op
                                },
                                modifier =
                                    Modifier.placeholder(
                                        true,
                                        shape = ButtonDefaults.filledTonalShape,
                                    ),
                            ) {
                                Text(text = stringResource(R.string.profile_header_button_follow))
                            }
                        }

                        is UiState.Success -> {
                            when (val data = relationState.data) {
                                is UiRelation.XQT -> {
                                    FilledTonalButton(
                                        onClick = {
                                            onFollowClick.invoke(data)
                                        },
                                    ) {
                                        Text(
                                            text =
                                                stringResource(
                                                    when {
                                                        data.blocking -> R.string.profile_header_button_blocked
                                                        data.following -> R.string.profile_header_button_following
                                                        else -> R.string.profile_header_button_follow
                                                    },
                                                ),
                                        )
                                    }
                                }

                                else -> Unit
                            }
                        }
                    }
                }
            }
            menu.invoke(this)
        },
        content = {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = screenHorizontalPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                user.descriptionElement?.let {
                    HtmlText2(
                        element = it,
                        layoutDirection = user.descriptionDirection,
                    )
                }
                UserFields(
                    fields = user.fieldsParsed,
                )
                MatricesDisplay(
                    matrices =
                        remember(user.matrices) {
                            persistentMapOf(
                                R.string.profile_misskey_header_status_count to user.matrices.statusesCountHumanized,
                                R.string.profile_header_following_count to user.matrices.followsCountHumanized,
                                R.string.profile_header_fans_count to user.matrices.fansCountHumanized,
                            )
                        },
                    expanded = expandMatrices,
                )
            }
        },
        modifier = modifier,
    )
}

@Composable
internal fun ColumnScope.XQTUserMenu(
    user: UiUser,
    relation: UiRelation.XQT,
    onBlockClick: () -> Unit,
) {
    DropdownMenuItem(
        text = {
            if (relation.blocking) {
                Text(text = stringResource(R.string.user_unblock, user.handle))
            } else {
                Text(text = stringResource(R.string.user_block, user.handle))
            }
        },
        onClick = onBlockClick,
    )
}
