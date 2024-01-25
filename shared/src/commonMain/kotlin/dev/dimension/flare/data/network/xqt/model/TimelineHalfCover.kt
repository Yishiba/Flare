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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param dismissible
 * @param halfCoverDisplayType
 * @param impressionCallbacks
 * @param primaryCoverCta
 * @param primaryText
 * @param secondaryText
 * @param type
 */
@Serializable
data class TimelineHalfCover(
    @SerialName(value = "dismissible")
    val dismissible: kotlin.Boolean? = null,
    @SerialName(value = "halfCoverDisplayType")
    val halfCoverDisplayType: TimelineHalfCover.HalfCoverDisplayType,
    @SerialName(value = "impressionCallbacks")
    val impressionCallbacks: kotlin.collections.List<Callback>,
    @SerialName(value = "primaryCoverCta")
    val primaryCoverCta: CoverCta,
    @SerialName(value = "primaryText")
    val primaryText: Text,
    @SerialName(value = "secondaryText")
    val secondaryText: Text,
    @SerialName(value = "type")
    val type: TimelineHalfCover.Type,
) {
    /**
     *
     *
     * Values: cover
     */
    @Serializable
    enum class HalfCoverDisplayType(val value: kotlin.String) {
        @SerialName(value = "Cover")
        cover("Cover"),
    }

    /**
     *
     *
     * Values: timelineHalfCover
     */
    @Serializable
    enum class Type(val value: kotlin.String) {
        @SerialName(value = "TimelineHalfCover")
        timelineHalfCover("TimelineHalfCover"),
    }
}
