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
 * Values: timelineAddEntries,timelineAddToModule,timelineClearCache,timelinePinEntry,timelineReplaceEntry,timelineShowAlert,timelineTerminateTimeline,timelineShowCover
 */
@Serializable
internal enum class InstructionType(val value: kotlin.String) {
    @SerialName(value = "TimelineAddEntries")
    timelineAddEntries("TimelineAddEntries"),

    @SerialName(value = "TimelineAddToModule")
    timelineAddToModule("TimelineAddToModule"),

    @SerialName(value = "TimelineClearCache")
    timelineClearCache("TimelineClearCache"),

    @SerialName(value = "TimelinePinEntry")
    timelinePinEntry("TimelinePinEntry"),

    @SerialName(value = "TimelineReplaceEntry")
    timelineReplaceEntry("TimelineReplaceEntry"),

    @SerialName(value = "TimelineShowAlert")
    timelineShowAlert("TimelineShowAlert"),

    @SerialName(value = "TimelineTerminateTimeline")
    timelineTerminateTimeline("TimelineTerminateTimeline"),

    @SerialName(value = "TimelineShowCover")
    timelineShowCover("TimelineShowCover"),
    ;

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is InstructionType) "$data" else null

        /**
         * Returns a valid [InstructionType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): InstructionType? =
            data?.let {
                val normalizedData = "$it".lowercase()
                values().firstOrNull { value ->
                    it == value || normalizedData == "$value".lowercase()
                }
            }
    }
}
