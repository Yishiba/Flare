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
 * @param span * @param host * @param limit * @param offset */
@Serializable
internal data class ChartsInstanceRequest(
    @SerialName(value = "span") val span: ChartsInstanceRequest.Span,
    @SerialName(value = "host") val host: kotlin.String,
    @SerialName(value = "limit") val limit: kotlin.Int? = 30,
    @SerialName(value = "offset") val offset: kotlin.Int? = null,
) {
    /**
     * *
     * Values: Day,Hour
     */
    @Serializable
    enum class Span(val value: kotlin.String) {
        @SerialName(value = "day")
        Day("day"),

        @SerialName(value = "hour")
        Hour("hour"),
    }
}
