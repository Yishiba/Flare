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
 * @param name * @param folderId */
@Serializable
data class DriveFilesFindRequest(

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "folderId") val folderId: kotlin.String? = null,

)
