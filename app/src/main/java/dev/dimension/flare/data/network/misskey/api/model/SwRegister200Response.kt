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

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param key * @param userId * @param endpoint * @param sendReadMessage * @param state */
@Serializable

data class SwRegister200Response(

    @SerialName(value = "key") @Required val key: kotlin.String?,

    @SerialName(value = "userId") @Required val userId: kotlin.String,

    @SerialName(value = "endpoint") @Required val endpoint: kotlin.String,

    @SerialName(value = "sendReadMessage") @Required val sendReadMessage: kotlin.Boolean,

    @SerialName(value = "state") val state: SwRegister200Response.State? = null

) {

    /**
     * *
     * Values: AlreadyMinusSubscribed,Subscribed
     */
    @Serializable
    enum class State(val value: kotlin.String) {
        @SerialName(value = "already-subscribed")
        AlreadyMinusSubscribed("already-subscribed"),

        @SerialName(value = "subscribed")
        Subscribed("subscribed");
    }
}
