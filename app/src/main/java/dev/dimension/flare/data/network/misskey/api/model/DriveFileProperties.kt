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
 * @param width * @param height * @param orientation * @param avgColor */
@Serializable
data class DriveFileProperties(

    @SerialName(value = "width") val width: kotlin.Double? = null,

    @SerialName(value = "height") val height: kotlin.Double? = null,

    @SerialName(value = "orientation") val orientation: kotlin.Double? = null,

    @SerialName(value = "avgColor") val avgColor: kotlin.String? = null,

)
