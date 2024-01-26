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
 * @param limit * @param sinceId * @param untilId * @param folderId * @param type * @param sort */
@Serializable
internal data class DriveFilesRequest(
    @SerialName(value = "limit") val limit: kotlin.Int? = 10,
    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,
    @SerialName(value = "untilId") val untilId: kotlin.String? = null,
    @SerialName(value = "folderId") val folderId: kotlin.String? = null,
    @SerialName(value = "type") val type: kotlin.String? = null,
    @SerialName(value = "sort") val sort: DriveFilesRequest.Sort? = null,
) {
    /**
     * *
     * Values: PlusCreatedAt,MinusCreatedAt,PlusName,MinusName,PlusSize,MinusSize
     */
    @Serializable
    enum class Sort(val value: kotlin.String) {
        @SerialName(value = "+createdAt")
        PlusCreatedAt("+createdAt"),

        @SerialName(value = "-createdAt")
        MinusCreatedAt("-createdAt"),

        @SerialName(value = "+name")
        PlusName("+name"),

        @SerialName(value = "-name")
        MinusName("-name"),

        @SerialName(value = "+size")
        PlusSize("+size"),

        @SerialName(value = "-size")
        MinusSize("-size"),
    }
}
