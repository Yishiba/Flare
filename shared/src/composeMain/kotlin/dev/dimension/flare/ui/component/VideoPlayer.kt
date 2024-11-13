package dev.dimension.flare.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.dimension.flare.ui.model.UiMedia

@Composable
expect fun VideoPlayer(
    data: UiMedia.Video,
    modifier: Modifier = Modifier,
)

@Composable
expect fun GifPlayer(
    data: UiMedia.Gif,
    modifier: Modifier = Modifier,
)

@Composable
expect fun AudioPlayer(
    data: UiMedia.Audio,
    modifier: Modifier = Modifier,
)
