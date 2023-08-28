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
 * @param id * @param createdAt * @param blockeeId * @param blockee */
@Serializable
data class Blocking(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "blockeeId") val blockeeId: kotlin.String,

    @SerialName(value = "blockee") val blockee: UserDetailed,

)
