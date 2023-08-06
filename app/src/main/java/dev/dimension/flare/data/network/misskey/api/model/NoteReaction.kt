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
 * @param id * @param createdAt * @param user * @param type */
@Serializable

data class NoteReaction(

    @SerialName(value = "id") @Required val id: kotlin.String,

    @SerialName(value = "createdAt") @Required val createdAt: kotlin.String,

    @SerialName(value = "user") @Required val user: UserLite,

    @SerialName(value = "type") @Required val type: kotlin.String

)
