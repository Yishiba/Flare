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
 * @param limit * @param sinceId * @param untilId * @param userId * @param type * @param origin * @param hostname The local host is represented with `null`.
 */
@Serializable
data class AdminDriveFilesRequest(

    @SerialName(value = "limit") val limit: kotlin.Int? = 10,

    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,

    @SerialName(value = "untilId") val untilId: kotlin.String? = null,

    @SerialName(value = "userId") val userId: kotlin.String? = null,

    @SerialName(value = "type") val type: kotlin.String? = null,

    @SerialName(value = "origin") val origin: AdminDriveFilesRequest.Origin? = Origin.Local,

    /* The local host is represented with `null`. */
    @SerialName(value = "hostname") val hostname: kotlin.String? = null,

) {

    /**
     * *
     * Values: Combined,Local,Remote
     */
    @Serializable
    enum class Origin(val value: kotlin.String) {
        @SerialName(value = "combined")
        Combined("combined"),

        @SerialName(value = "local")
        Local("local"),

        @SerialName(value = "remote")
        Remote("remote"),
    }
}
