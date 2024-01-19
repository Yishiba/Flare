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
 * @param displayUrl
 * @param expandedUrl
 * @param idStr
 * @param indices
 * @param mediaKey
 * @param mediaUrlHttps
 * @param originalInfo
 * @param sizes
 * @param type
 * @param url
 * @param additionalMediaInfo
 * @param extMediaAvailability
 * @param features
 * @param mediaStats
 * @param videoInfo
 */
@Serializable
data class MediaExtended(
    @Contextual @SerialName(value = "display_url")
    val displayUrl: java.net.URI,
    @Contextual @SerialName(value = "expanded_url")
    val expandedUrl: java.net.URI,
    @SerialName(value = "id_str")
    val idStr: kotlin.String,
    @SerialName(value = "indices")
    val indices: kotlin.collections.List<kotlin.Int>,
    @SerialName(value = "media_key")
    val mediaKey: kotlin.String,
    @Contextual @SerialName(value = "media_url_https")
    val mediaUrlHttps: java.net.URI,
    @SerialName(value = "original_info")
    val originalInfo: MediaOriginalInfo,
    @SerialName(value = "sizes")
    val sizes: MediaSizes,
    @SerialName(value = "type")
    val type: MediaExtended.Type,
    @Contextual @SerialName(value = "url")
    val url: java.net.URI,
    @SerialName(value = "additional_media_info")
    val additionalMediaInfo: AdditionalMediaInfo? = null,
    @SerialName(value = "ext_media_availability")
    val extMediaAvailability: ExtMediaAvailability? = null,
    @Contextual @SerialName(value = "features")
    val features: kotlin.Any? = null,
    @SerialName(value = "mediaStats")
    val mediaStats: MediaStats? = null,
    @SerialName(value = "video_info")
    val videoInfo: MediaVideoInfo? = null,
) {
    /**
     *
     *
     * Values: photo,video,animatedGif
     */
    @Serializable
    enum class Type(val value: kotlin.String) {
        @SerialName(value = "photo")
        photo("photo"),

        @SerialName(value = "video")
        video("video"),

        @SerialName(value = "animated_gif")
        animatedGif("animated_gif"),
    }
}
