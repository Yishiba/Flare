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

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param typename
 * @param timelineV2
 */
@Serializable
data class UserTweetsResult(
    @Contextual @SerialName(value = "__typename")
    val typename: TypeName,
    @SerialName(value = "timeline_v2")
    val timelineV2: TimelineV2,
)
