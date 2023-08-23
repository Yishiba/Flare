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
 * @param id * @param inbox * @param status */
@Serializable

data class AdminRelaysAdd200Response(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "inbox") val inbox: kotlin.String,

    @SerialName(value = "status") val status: AdminRelaysAdd200Response.Status = Status.Requesting

) {

    /**
     * *
     * Values: Requesting,Accepted,Rejected
     */
    @Serializable
    enum class Status(val value: kotlin.String) {
        @SerialName(value = "requesting")
        Requesting("requesting"),

        @SerialName(value = "accepted")
        Accepted("accepted"),

        @SerialName(value = "rejected")
        Rejected("rejected");
    }
}
