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
 * @param type
 */
@Serializable
internal data class TimelineCoverBehavior(
    @SerialName(value = "type")
    val type: TimelineCoverBehavior.Type,
) {
    /**
     *
     *
     * Values: timelineCoverBehaviorDismiss
     */
    @Serializable
    enum class Type(
        val value: kotlin.String,
    ) {
        @SerialName(value = "TimelineCoverBehaviorDismiss")
        timelineCoverBehaviorDismiss("TimelineCoverBehaviorDismiss"),
    }
}
