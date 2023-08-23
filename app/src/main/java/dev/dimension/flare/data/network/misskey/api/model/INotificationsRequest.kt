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
 * @param limit * @param sinceId * @param untilId * @param markAsRead * @param includeTypes * @param excludeTypes */
@Serializable

data class INotificationsRequest(

    @SerialName(value = "limit") val limit: kotlin.Int? = 10,

    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,

    @SerialName(value = "untilId") val untilId: kotlin.String? = null,

    @SerialName(value = "markAsRead") val markAsRead: kotlin.Boolean? = true,

    @SerialName(value = "includeTypes") val includeTypes: kotlin.collections.List<INotificationsRequest.IncludeTypes>? = null,

    @SerialName(value = "excludeTypes") val excludeTypes: kotlin.collections.List<INotificationsRequest.ExcludeTypes>? = null

) {

    /**
     * *
     * Values: Follow,Mention,Reply,Renote,Quote,Reaction,PollEnded,ReceiveFollowRequest,FollowRequestAccepted,AchievementEarned,App,PollVote,GroupInvited
     */
    @Serializable
    enum class IncludeTypes(val value: kotlin.String) {
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

        @SerialName(value = "pollVote")
        PollVote("pollVote"),

        @SerialName(value = "groupInvited")
        GroupInvited("groupInvited");
    }

    /**
     * *
     * Values: Follow,Mention,Reply,Renote,Quote,Reaction,PollEnded,ReceiveFollowRequest,FollowRequestAccepted,AchievementEarned,App,PollVote,GroupInvited
     */
    @Serializable
    enum class ExcludeTypes(val value: kotlin.String) {
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

        @SerialName(value = "pollVote")
        PollVote("pollVote"),

        @SerialName(value = "groupInvited")
        GroupInvited("groupInvited");
    }
}
