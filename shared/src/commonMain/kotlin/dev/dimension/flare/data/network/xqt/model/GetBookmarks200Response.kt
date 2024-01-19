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
 * @param `data`
 * @param errors
 */
@Serializable
data class GetBookmarks200Response(
    @SerialName(value = "data")
    val `data`: BookmarksResponseData,
    @SerialName(value = "errors")
    val errors: kotlin.collections.List<Error>,
)
