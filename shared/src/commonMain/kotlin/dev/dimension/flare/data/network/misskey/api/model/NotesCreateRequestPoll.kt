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
 * @param choices * @param multiple * @param expiresAt * @param expiredAfter */
@Serializable
internal data class NotesCreateRequestPoll(
    @SerialName(value = "choices") val choices: kotlin.collections.Set<kotlin.String>,
    @SerialName(value = "multiple") val multiple: kotlin.Boolean? = null,
    @SerialName(value = "expiresAt") val expiresAt: kotlin.Int? = null,
    @SerialName(value = "expiredAfter") val expiredAfter: kotlin.Int? = null,
)
