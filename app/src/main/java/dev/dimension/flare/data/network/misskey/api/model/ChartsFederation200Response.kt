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
 * @param deliveredInstances * @param inboxInstances * @param stalled * @param sub * @param pub * @param pubsub * @param subActive * @param pubActive */
@Serializable
data class ChartsFederation200Response(

    @SerialName(value = "deliveredInstances") val deliveredInstances: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "inboxInstances") val inboxInstances: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "stalled") val stalled: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "sub") val sub: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "pub") val pub: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "pubsub") val pubsub: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "subActive") val subActive: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "pubActive") val pubActive: kotlin.collections.List<kotlin.Double>,

)
