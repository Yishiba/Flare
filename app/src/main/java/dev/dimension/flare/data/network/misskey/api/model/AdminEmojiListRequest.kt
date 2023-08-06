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
 * @param query * @param limit * @param sinceId * @param untilId */
@Serializable

data class AdminEmojiListRequest(

    @SerialName(value = "query") val query: kotlin.String? = null,

    @SerialName(value = "limit") val limit: kotlin.Int? = 10,

    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,

    @SerialName(value = "untilId") val untilId: kotlin.String? = null

)
