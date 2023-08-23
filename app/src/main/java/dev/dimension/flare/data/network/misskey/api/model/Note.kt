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

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param id * @param createdAt * @param text * @param userId * @param user * @param visibility * @param reactionAcceptance * @param reactions * @param renoteCount * @param repliesCount * @param deletedAt * @param cw * @param replyId * @param renoteId * @param reply * @param renote * @param isHidden * @param mentions * @param visibleUserIds * @param fileIds * @param files * @param tags * @param poll * @param channelId * @param channel * @param localOnly * @param uri * @param url * @param myReaction */
@Serializable

data class Note(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "text") val text: kotlin.String? = null,

    @SerialName(value = "userId") val userId: kotlin.String,

    @SerialName(value = "user") val user: UserLite,

    @SerialName(value = "visibility") val visibility: Visibility,

    @SerialName(value = "reactionAcceptance") val reactionAcceptance: kotlin.String? = null,

    @SerialName(value = "reactions") val reactions: Map<kotlin.String, kotlin.Long>,

    @SerialName(value = "reactionEmojis") val reactionEmojis: Map<kotlin.String, kotlin.String>? = null,

    @SerialName(value = "renoteCount") val renoteCount: kotlin.Double,

    @SerialName(value = "repliesCount") val repliesCount: kotlin.Double,

    @SerialName(value = "deletedAt") val deletedAt: kotlin.String? = null,

    @SerialName(value = "cw") val cw: kotlin.String? = null,

    @SerialName(value = "replyId") val replyId: kotlin.String? = null,

    @SerialName(value = "renoteId") val renoteId: kotlin.String? = null,

    @SerialName(value = "reply") val reply: Note? = null,

    @SerialName(value = "renote") val renote: Note? = null,

    @SerialName(value = "isHidden") val isHidden: kotlin.Boolean? = null,

    @SerialName(value = "mentions") val mentions: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "visibleUserIds") val visibleUserIds: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "fileIds") val fileIds: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "files") val files: kotlin.collections.List<@Contextual DriveFile>? = null,

    @SerialName(value = "tags") val tags: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "poll") val poll: Poll? = null,

    @SerialName(value = "channelId") val channelId: kotlin.String? = null,

    @SerialName(value = "channel") val channel: kotlin.collections.List<NoteChannelInner>? = null,

    @SerialName(value = "localOnly") val localOnly: kotlin.Boolean? = null,

    @SerialName(value = "uri") val uri: kotlin.String? = null,

    @SerialName(value = "url") val url: kotlin.String? = null,

    @SerialName(value = "myReaction") val myReaction: kotlin.String? = null

)
