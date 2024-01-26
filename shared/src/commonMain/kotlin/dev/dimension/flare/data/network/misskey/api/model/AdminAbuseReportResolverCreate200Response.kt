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
 * @param name * @param targetUserPattern * @param reporterPattern * @param reportContentPattern * @param expiresAt * @param forward */
@Serializable
internal data class AdminAbuseReportResolverCreate200Response(
    @SerialName(value = "name") val name: kotlin.String,
    @SerialName(value = "targetUserPattern") val targetUserPattern: kotlin.String? = null,
    @SerialName(value = "reporterPattern") val reporterPattern: kotlin.String? = null,
    @SerialName(value = "reportContentPattern") val reportContentPattern: kotlin.String? = null,
    @SerialName(value = "expiresAt") val expiresAt: kotlin.String,
    @SerialName(value = "forward") val forward: kotlin.Boolean,
)
