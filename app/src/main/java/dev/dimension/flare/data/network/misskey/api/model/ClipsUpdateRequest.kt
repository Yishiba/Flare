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
 * @param clipId * @param name * @param isPublic * @param description */
@Serializable

data class ClipsUpdateRequest(

    @SerialName(value = "clipId") @Required val clipId: kotlin.String,

    @SerialName(value = "name") @Required val name: kotlin.String,

    @SerialName(value = "isPublic") val isPublic: kotlin.Boolean? = null,

    @SerialName(value = "description") val description: kotlin.String? = null

)
