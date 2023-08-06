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
 * @param id * @param createdAt * @param note * @param noteId */
@Serializable

data class NoteFavorite(

    @SerialName(value = "id") @Required val id: kotlin.String,

    @SerialName(value = "createdAt") @Required val createdAt: kotlin.String,

    @SerialName(value = "note") @Required val note: Note,

    @SerialName(value = "noteId") @Required val noteId: kotlin.String

)
