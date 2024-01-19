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
 * @param h
 * @param resize
 * @param w
 */
@Serializable
data class MediaSize(
    @SerialName(value = "h")
    val h: kotlin.Int,
    @SerialName(value = "resize")
    val resize: MediaSize.Resize,
    @SerialName(value = "w")
    val w: kotlin.Int,
) {
    /**
     *
     *
     * Values: crop,fit
     */
    @Serializable
    enum class Resize(val value: kotlin.String) {
        @SerialName(value = "crop")
        crop("crop"),

        @SerialName(value = "fit")
        fit("fit"),
    }
}
