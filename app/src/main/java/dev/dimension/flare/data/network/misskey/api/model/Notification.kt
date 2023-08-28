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
 * @param id * @param createdAt * @param type * @param user * @param userId * @param note * @param reaction * @param choice * @param invitation * @param body * @param header * @param icon */
@Serializable
data class Notification(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "type") val type: Notification.Type,

    @SerialName(value = "user") val user: UserLite? = null,

    @SerialName(value = "userId") val userId: kotlin.String? = null,

    @SerialName(value = "note") val note: Note? = null,

    @SerialName(value = "reaction") val reaction: kotlin.String? = null,

    @SerialName(value = "choice") val choice: kotlin.Double? = null,

    @SerialName(value = "invitation") val invitation: kotlin.String? = null,

    @SerialName(value = "body") val body: kotlin.String? = null,

    @SerialName(value = "header") val header: kotlin.String? = null,

    @SerialName(value = "icon") val icon: kotlin.String? = null,
    val achievement: String? = null,
) {

    /**
     * *
     * Values: Follow,Mention,Reply,Renote,Quote,Reaction,PollEnded,ReceiveFollowRequest,FollowRequestAccepted,AchievementEarned,App
     */
    @Serializable
    enum class Type(val value: kotlin.String) {
        @SerialName(value = "follow")
        Follow("follow"),

        @SerialName(value = "mention")
        Mention("mention"),

        @SerialName(value = "reply")
        Reply("reply"),

        @SerialName(value = "renote")
        Renote("renote"),

        @SerialName(value = "quote")
        Quote("quote"),

        @SerialName(value = "reaction")
        Reaction("reaction"),

        @SerialName(value = "pollEnded")
        PollEnded("pollEnded"),

        @SerialName(value = "receiveFollowRequest")
        ReceiveFollowRequest("receiveFollowRequest"),

        @SerialName(value = "followRequestAccepted")
        FollowRequestAccepted("followRequestAccepted"),

        @SerialName(value = "achievementEarned")
        AchievementEarned("achievementEarned"),

        @SerialName(value = "app")
        App("app"),
    }
}
