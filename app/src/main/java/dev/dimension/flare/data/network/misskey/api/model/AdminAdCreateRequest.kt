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
 * @param url * @param memo * @param place * @param priority * @param ratio * @param expiresAt * @param startsAt * @param imageUrl * @param dayOfWeek */
@Serializable

data class AdminAdCreateRequest(

    @SerialName(value = "url") val url: kotlin.String,

    @SerialName(value = "memo") val memo: kotlin.String,

    @SerialName(value = "place") val place: kotlin.String,

    @SerialName(value = "priority") val priority: kotlin.String,

    @SerialName(value = "ratio") val ratio: kotlin.Int,

    @SerialName(value = "expiresAt") val expiresAt: kotlin.Int,

    @SerialName(value = "startsAt") val startsAt: kotlin.Int,

    @SerialName(value = "imageUrl") val imageUrl: kotlin.String,

    @SerialName(value = "dayOfWeek") val dayOfWeek: kotlin.Int

)
