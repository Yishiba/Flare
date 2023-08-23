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
 * @param id * @param createdAt * @param followeeId * @param followerId * @param followee * @param follower */
@Serializable

data class Following(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "followeeId") val followeeId: kotlin.String,

    @SerialName(value = "followerId") val followerId: kotlin.String,

    @SerialName(value = "followee") val followee: UserDetailed? = null,

    @SerialName(value = "follower") val follower: UserDetailed? = null

)
