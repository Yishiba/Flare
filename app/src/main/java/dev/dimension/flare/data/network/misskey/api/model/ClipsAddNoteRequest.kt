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
 * @param clipId * @param noteId */
@Serializable

data class ClipsAddNoteRequest(

    @SerialName(value = "clipId") @Required val clipId: kotlin.String,

    @SerialName(value = "noteId") @Required val noteId: kotlin.String

)
