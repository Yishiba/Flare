/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport",
)

package dev.dimension.flare.data.network.xqt.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param typename
 * @param clientEventInfo
 * @param displayType
 * @param entryType
 * @param footer
 * @param header
 * @param items
 */
@Serializable
@SerialName("TimelineTimelineModule")
data class TimelineTimelineModule(
//    @Contextual @SerialName(value = "__typename")
//    val typename: TypeName,
//    @Contextual @SerialName(value = "clientEventInfo")
//    val clientEventInfo: kotlin.collections.Map<kotlin.String, kotlin.Any>,
//    @SerialName(value = "displayType")
//    val displayType: TimelineTimelineModule.DisplayType,
    @Contextual @SerialName(value = "entryType")
    val entryType: ContentEntryType,
//    @Contextual @SerialName(value = "footer")
//    val footer: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
//    @Contextual @SerialName(value = "header")
//    val header: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
    @SerialName(value = "items")
    val items: kotlin.collections.List<ModuleItem>? = null,
) : ContentUnion {
    /**
     *
     *
     * Values: vertical,verticalConversation,carousel
     */
    @Serializable
    enum class DisplayType(val value: kotlin.String) {
        @SerialName(value = "Vertical")
        vertical("Vertical"),

        @SerialName(value = "VerticalConversation")
        verticalConversation("VerticalConversation"),

        @SerialName(value = "Carousel")
        carousel("Carousel"),
    }
}
