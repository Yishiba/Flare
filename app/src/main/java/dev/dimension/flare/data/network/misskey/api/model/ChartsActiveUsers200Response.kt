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
 * @param readWrite * @param read * @param write * @param registeredWithinWeek * @param registeredWithinMonth * @param registeredWithinYear * @param registeredOutsideWeek * @param registeredOutsideMonth * @param registeredOutsideYear */
@Serializable

data class ChartsActiveUsers200Response(

    @SerialName(value = "readWrite") val readWrite: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "read") val read: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "write") val write: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "registeredWithinWeek") val registeredWithinWeek: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "registeredWithinMonth") val registeredWithinMonth: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "registeredWithinYear") val registeredWithinYear: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "registeredOutsideWeek") val registeredOutsideWeek: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "registeredOutsideMonth") val registeredOutsideMonth: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "registeredOutsideYear") val registeredOutsideYear: kotlin.collections.List<kotlin.Double>

)
