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
 * @param h
 * @param w
 * @param x
 * @param y
 */
@Serializable
internal data class MediaOriginalInfoFocusRect(
    @SerialName(value = "h")
    val h: kotlin.Int,
    @SerialName(value = "w")
    val w: kotlin.Int,
    @SerialName(value = "x")
    val x: kotlin.Int,
    @SerialName(value = "y")
    val y: kotlin.Int,
)
