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
 * @param code
 * @param kind
 * @param name
 * @param source
 * @param tracing
 */
@Serializable
data class Extensions(
    @SerialName(value = "code")
    val code: kotlin.Int,
    @SerialName(value = "kind")
    val kind: kotlin.String,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "source")
    val source: kotlin.String,
    @SerialName(value = "tracing")
    val tracing: Tracing,
)
