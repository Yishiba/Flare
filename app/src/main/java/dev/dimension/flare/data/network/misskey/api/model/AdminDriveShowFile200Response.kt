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
 * @param id * @param createdAt * @param userId * @param userHost The local host is represented with `null`.
 * @param md5 * @param name * @param type * @param propertySize * @param comment * @param blurhash * @param properties * @param storedInternal * @param url * @param thumbnailUrl * @param webpublicUrl * @param accessKey * @param thumbnailAccessKey * @param webpublicAccessKey * @param uri * @param src * @param folderId * @param isSensitive * @param isLink */
@Serializable

data class AdminDriveShowFile200Response(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "userId") val userId: kotlin.String? = null,

    /* The local host is represented with `null`. */
    @SerialName(value = "userHost") val userHost: kotlin.String? = null,

    @SerialName(value = "md5") val md5: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "type") val type: kotlin.String,

    @SerialName(value = "size") val propertySize: kotlin.Double,

    @SerialName(value = "comment") val comment: kotlin.String? = null,

    @SerialName(value = "blurhash") val blurhash: kotlin.String? = null,

    @SerialName(value = "properties") val properties: kotlin.String,

    @SerialName(value = "storedInternal") val storedInternal: kotlin.Boolean? = null,

    @SerialName(value = "url") val url: kotlin.String? = null,

    @SerialName(value = "thumbnailUrl") val thumbnailUrl: kotlin.String? = null,

    @SerialName(value = "webpublicUrl") val webpublicUrl: kotlin.String? = null,

    @SerialName(value = "accessKey") val accessKey: kotlin.String? = null,

    @SerialName(value = "thumbnailAccessKey") val thumbnailAccessKey: kotlin.String? = null,

    @SerialName(value = "webpublicAccessKey") val webpublicAccessKey: kotlin.String? = null,

    @SerialName(value = "uri") val uri: kotlin.String? = null,

    @SerialName(value = "src") val src: kotlin.String? = null,

    @SerialName(value = "folderId") val folderId: kotlin.String? = null,

    @SerialName(value = "isSensitive") val isSensitive: kotlin.Boolean,

    @SerialName(value = "isLink") val isLink: kotlin.Boolean

)
