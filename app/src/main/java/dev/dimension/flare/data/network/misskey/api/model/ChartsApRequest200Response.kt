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
 * @param deliverFailed * @param deliverSucceeded * @param inboxReceived */
@Serializable

data class ChartsApRequest200Response(

    @SerialName(value = "deliverFailed") val deliverFailed: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "deliverSucceeded") val deliverSucceeded: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "inboxReceived") val inboxReceived: kotlin.collections.List<kotlin.Double>

)
