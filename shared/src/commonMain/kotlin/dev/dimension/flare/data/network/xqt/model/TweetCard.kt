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

package dev.dimension.flare.data.network.xqt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param legacy
 * @param restId
 */
@Serializable
data class TweetCard(
    @SerialName(value = "legacy")
    val legacy: TweetCardLegacy? = null,
//    @SerialName(value = "rest_id")
//    val restId: kotlin.String? = null,
)
