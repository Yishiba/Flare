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
 * @param limit * @param offset * @param userId */
@Serializable

data class AdminAnnouncementsListRequest(

    @SerialName(value = "limit") val limit: kotlin.Int? = 10,

    @SerialName(value = "offset") val offset: kotlin.Int? = 0,

    @SerialName(value = "userId") val userId: kotlin.String? = null

)
