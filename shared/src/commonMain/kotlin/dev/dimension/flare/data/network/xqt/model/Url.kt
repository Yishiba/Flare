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
 * @param displayUrl
 * @param expandedUrl
 * @param indices
 * @param url
 */
@Serializable
internal data class Url(
    @SerialName(value = "display_url")
    val displayUrl: kotlin.String,
    @Contextual @SerialName(value = "expanded_url")
    val expandedUrl: String,
    @SerialName(value = "indices")
    val indices: kotlin.collections.List<kotlin.Int>,
    @Contextual @SerialName(value = "url")
    val url: String,
)
