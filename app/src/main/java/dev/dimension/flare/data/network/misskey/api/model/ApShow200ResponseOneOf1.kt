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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param type * @param `object` */
@Serializable

data class ApShow200ResponseOneOf1(

    @SerialName(value = "type") val type: ApShow200ResponseOneOf1.Type,

    @SerialName(value = "object") val `object`: Note

) {

    /**
     * *
     * Values: Note
     */
    @Serializable
    enum class Type(val value: kotlin.String) {
        @SerialName(value = "Note")
        Note("Note");
    }
}
