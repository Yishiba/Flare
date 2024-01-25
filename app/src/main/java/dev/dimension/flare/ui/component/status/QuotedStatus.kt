package dev.dimension.flare.ui.component.status

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.dimension.flare.data.model.LocalAppearanceSettings
import dev.dimension.flare.ui.component.AdaptiveGrid
import dev.dimension.flare.ui.component.AvatarComponent
import dev.dimension.flare.ui.component.HtmlText2
import dev.dimension.flare.ui.model.UiMedia
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.contentDirection
import dev.dimension.flare.ui.theme.MediumAlpha
import kotlinx.collections.immutable.ImmutableList
import moe.tlaster.ktml.dom.Element

@Composable
internal fun UiStatusQuoted(
    status: UiStatus,
    onMediaClick: (UiMedia) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (status) {
        is UiStatus.Mastodon -> {
            QuotedStatus(
                avatarUrl = status.user.avatarUrl,
                nameElement = status.user.nameElement,
                handle = status.user.handle,
                contentElement = status.contentToken,
                contentLayoutDirection = status.contentDirection,
                medias = status.media,
                createdAt = status.humanizedTime,
                onMediaClick = onMediaClick,
                modifier = modifier,
            )
        }
        is UiStatus.MastodonNotification -> Unit
        is UiStatus.Misskey ->
            QuotedStatus(
                avatarUrl = status.user.avatarUrl,
                nameElement = status.user.nameElement,
                handle = status.user.handle,
                contentElement = status.contentToken,
                contentLayoutDirection = status.contentDirection,
                medias = status.media,
                createdAt = status.humanizedTime,
                onMediaClick = onMediaClick,
                modifier = modifier,
            )

        is UiStatus.MisskeyNotification -> Unit
        is UiStatus.Bluesky ->
            QuotedStatus(
                avatarUrl = status.user.avatarUrl,
                nameElement = status.user.nameElement,
                handle = status.user.handle,
                contentElement = status.contentToken,
                contentLayoutDirection = status.contentDirection,
                medias = status.medias,
                createdAt = status.humanizedTime,
                onMediaClick = onMediaClick,
                modifier = modifier,
            )
        is UiStatus.BlueskyNotification -> Unit
        is UiStatus.XQT ->
            QuotedStatus(
                avatarUrl = status.user.avatarUrl,
                nameElement = status.user.nameElement,
                handle = status.user.handle,
                contentElement = status.contentToken,
                contentLayoutDirection = status.contentDirection,
                medias = status.medias,
                createdAt = status.humanizedTime,
                onMediaClick = onMediaClick,
                modifier = modifier,
            )
    }
}

@Composable
internal fun QuotedStatus(
    avatarUrl: String,
    nameElement: Element,
    handle: String,
    contentElement: Element,
    contentLayoutDirection: LayoutDirection,
    medias: ImmutableList<UiMedia>?,
    createdAt: String,
    onMediaClick: (UiMedia) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column {
            Column(
                modifier =
                    Modifier
                        .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AvatarComponent(
                        data = avatarUrl,
                        size = 20.dp,
                    )
                    Row(
                        modifier =
                            Modifier
                                .weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        HtmlText2(
                            element = nameElement,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = handle,
                            style = MaterialTheme.typography.bodySmall,
                            modifier =
                                Modifier
                                    .alpha(MediumAlpha),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    Text(
                        text = createdAt,
                        style = MaterialTheme.typography.bodySmall,
                        modifier =
                            Modifier
                                .alpha(MediumAlpha),
                        maxLines = 1,
                    )
                }
                HtmlText2(element = contentElement, layoutDirection = contentLayoutDirection)
            }
            if (medias != null && LocalAppearanceSettings.current.showMedia) {
                AdaptiveGrid(
                    modifier =
                        Modifier
                            .clip(MaterialTheme.shapes.medium),
                    content = {
                        medias.forEach { media ->
                            MediaItem(
                                media = media,
                                modifier =
                                    Modifier
                                        .clickable {
                                            onMediaClick(media)
                                        },
                            )
                        }
                    },
                )
            }
        }
    }
}
