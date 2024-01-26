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
 * @param webhookId * @param name * @param url * @param secret * @param on * @param active */
@Serializable
internal data class IWebhooksUpdateRequest(
    @SerialName(value = "webhookId") val webhookId: kotlin.String,
    @SerialName(value = "name") val name: kotlin.String,
    @SerialName(value = "url") val url: kotlin.String,
    @SerialName(value = "secret") val secret: kotlin.String,
    @SerialName(value = "on") val on: kotlin.collections.List<IWebhooksUpdateRequest.On>,
    @SerialName(value = "active") val active: kotlin.Boolean,
) {
    /**
     * *
     * Values: Mention,Unfollow,Follow,Followed,Note,Reply,Renote,Reaction
     */
    @Serializable
    enum class On(val value: kotlin.String) {
        @SerialName(value = "mention")
        Mention("mention"),

        @SerialName(value = "unfollow")
        Unfollow("unfollow"),

        @SerialName(value = "follow")
        Follow("follow"),

        @SerialName(value = "followed")
        Followed("followed"),

        @SerialName(value = "note")
        Note("note"),

        @SerialName(value = "reply")
        Reply("reply"),

        @SerialName(value = "renote")
        Renote("renote"),

        @SerialName(value = "reaction")
        Reaction("reaction"),
    }
}
