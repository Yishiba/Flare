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

package dev.dimension.flare.data.network.misskey.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param pageId * @param title * @param name * @param content * @param variables * @param script * @param summary * @param eyeCatchingImageId * @param font * @param alignCenter * @param hideTitleWhenPinned */
@Serializable
data class PagesUpdateRequest(

    @SerialName(value = "pageId") val pageId: kotlin.String,

    @SerialName(value = "title") val title: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String,

//    @SerialName(value = "content") val content: kotlin.collections.List<@Contextual kotlin.collections.Map<kotlin.String, kotlin.Any>>,

//    @SerialName(value = "variables") val variables: kotlin.collections.List<@Contextual kotlin.collections.Map<kotlin.String, kotlin.Any>>,

    @SerialName(value = "script") val script: kotlin.String,

    @SerialName(value = "summary") val summary: kotlin.String? = null,

    @SerialName(value = "eyeCatchingImageId") val eyeCatchingImageId: kotlin.String? = null,

    @SerialName(value = "font") val font: PagesUpdateRequest.Font? = null,

    @SerialName(value = "alignCenter") val alignCenter: kotlin.Boolean? = null,

    @SerialName(value = "hideTitleWhenPinned") val hideTitleWhenPinned: kotlin.Boolean? = null,

) {

    /**
     * *
     * Values: Serif,SansMinusSerif
     */
    @Serializable
    enum class Font(val value: kotlin.String) {
        @SerialName(value = "serif")
        Serif("serif"),

        @SerialName(value = "sans-serif")
        SansMinusSerif("sans-serif"),
    }
}
