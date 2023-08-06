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
 * @param channelId * @param limit * @param sinceId * @param untilId * @param sinceDate * @param untilDate */
@Serializable

data class ChannelsTimelineRequest(

    @SerialName(value = "channelId") @Required val channelId: kotlin.String,

    @SerialName(value = "limit") val limit: kotlin.Int? = 10,

    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,

    @SerialName(value = "untilId") val untilId: kotlin.String? = null,

    @SerialName(value = "sinceDate") val sinceDate: kotlin.Int? = null,

    @SerialName(value = "untilDate") val untilDate: kotlin.Int? = null

)
