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

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param id * @param createdAt * @param name * @param type * @param md5 * @param propertySize * @param isSensitive * @param blurhash * @param properties * @param url * @param thumbnailUrl * @param comment * @param folderId * @param userId * @param folder * @param user */
@Serializable

data class DriveFile(

    @SerialName(value = "id") @Required val id: kotlin.String,

    @SerialName(value = "createdAt") @Required val createdAt: kotlin.String,

    @SerialName(value = "name") @Required val name: kotlin.String,

    @SerialName(value = "type") @Required val type: kotlin.String,

    @SerialName(value = "md5") @Required val md5: kotlin.String,

    @SerialName(value = "size") @Required val propertySize: kotlin.Double,

    @SerialName(value = "isSensitive") @Required val isSensitive: kotlin.Boolean,

    @SerialName(value = "blurhash") @Required val blurhash: kotlin.String?,

    @SerialName(value = "properties") @Required val properties: DriveFileProperties,

    @SerialName(value = "url") @Required val url: kotlin.String?,

    @SerialName(value = "thumbnailUrl") @Required val thumbnailUrl: kotlin.String?,

    @SerialName(value = "comment") @Required val comment: kotlin.String?,

    @SerialName(value = "folderId") @Required val folderId: kotlin.String?,

    @SerialName(value = "userId") @Required val userId: kotlin.String?,

    @SerialName(value = "folder") val folder: DriveFolder? = null,

    @SerialName(value = "user") val user: UserLite? = null

)
