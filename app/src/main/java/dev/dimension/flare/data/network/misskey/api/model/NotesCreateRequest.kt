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
    "UnusedImport"
)

package dev.dimension.flare.data.network.misskey.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 */
@Serializable

data class NotesCreateRequest(
    @SerialName("visibility")
    val visibility: String? = null,

    @SerialName("visibleUserIds")
    val visibleUserIds: List<String>? = null,

    @SerialName("text")
    val text: String? = null,

    @SerialName("cw")
    val cw: String? = null,

    @SerialName("viaMobile")
    val viaMobile: Boolean? = null,

    @SerialName("localOnly")
    val localOnly: Boolean? = null,

    @SerialName("noExtractMentions")
    val noExtractMentions: Boolean? = null,

    @SerialName("noExtractHashtags")
    val noExtractHashtags: Boolean? = null,

    @SerialName("noExtractEmojis")
    val noExtractEmojis: Boolean? = null,

    @SerialName("fileIds")
    var fileIds: List<String>? = null,

    @SerialName("replyId")
    val replyId: String? = null,

    @SerialName("renoteId")
    val renoteId: String? = null,

    @SerialName("poll")
    val poll: NotesCreateRequestPoll? = null,

    @SerialName("channelId")
    val channelId: String? = null,

    @SerialName("reactionAcceptance")
    val reactionAcceptance: String? = null
)
