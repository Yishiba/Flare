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
 * @param reportId * @param forward */
@Serializable

data class AdminResolveAbuseUserReportRequest(

    @SerialName(value = "reportId") @Required val reportId: kotlin.String,

    @SerialName(value = "forward") val forward: kotlin.Boolean? = false

)
