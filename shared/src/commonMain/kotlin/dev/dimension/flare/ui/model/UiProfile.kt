package dev.dimension.flare.ui.model

import androidx.compose.runtime.Immutable
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.model.PlatformType
import dev.dimension.flare.ui.humanizer.humanize
import dev.dimension.flare.ui.render.UiRichText
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlin.jvm.JvmInline

@Immutable
data class UiProfile internal constructor(
    override val key: MicroBlogKey,
    override val handle: String,
    override val avatar: String,
    override val name: UiRichText,
    override val platformType: PlatformType,
    override val onClicked: ClickContext.() -> Unit,
    val banner: String?,
    val description: UiRichText?,
    val matrices: Matrices,
    val mark: ImmutableList<Mark>,
    val bottomContent: BottomContent?,
) : UiUserV2 {
    @Immutable
    data class Matrices(
        val fansCount: Long,
        val followsCount: Long,
        val statusesCount: Long,
        val platformFansCount: String? = null,
    ) {
        val fansCountHumanized = platformFansCount ?: fansCount.humanize()
        val followsCountHumanized = followsCount.humanize()
        val statusesCountHumanized = statusesCount.humanize()
    }

    sealed interface BottomContent {
        @JvmInline
        value class Fields(
            val fields: ImmutableMap<String, UiRichText>,
        ) : BottomContent

        data class Iconify(
            val items: ImmutableMap<Icon, UiRichText>,
        ) : BottomContent {
            enum class Icon {
                Location,
                Url,
                Verify,
            }
        }
    }

    enum class Mark {
        Verified,
        Cat,
        Bot,
        Locked,
    }
}
