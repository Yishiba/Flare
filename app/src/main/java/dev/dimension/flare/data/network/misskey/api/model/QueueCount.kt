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
 * @param waiting * @param active * @param completed * @param failed * @param delayed */
@Serializable

data class QueueCount(

    @SerialName(value = "waiting") @Required val waiting: kotlin.Double,

    @SerialName(value = "active") @Required val active: kotlin.Double,

    @SerialName(value = "completed") @Required val completed: kotlin.Double,

    @SerialName(value = "failed") @Required val failed: kotlin.Double,

    @SerialName(value = "delayed") @Required val delayed: kotlin.Double

)
