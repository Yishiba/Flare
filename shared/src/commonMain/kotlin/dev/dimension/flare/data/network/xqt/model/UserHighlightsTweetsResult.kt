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
 * @param timeline
 */
@Serializable
data class UserHighlightsTweetsResult(
    @Contextual @SerialName(value = "__typename")
    val typename: TypeName,
    @SerialName(value = "timeline")
    val timeline: UserHighlightsTweetsTimeline,
)
