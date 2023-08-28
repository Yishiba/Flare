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
 * @param localFollowingsTotal * @param localFollowingsInc * @param localFollowingsDec * @param localFollowersTotal * @param localFollowersInc * @param localFollowersDec * @param remoteFollowingsTotal * @param remoteFollowingsInc * @param remoteFollowingsDec * @param remoteFollowersTotal * @param remoteFollowersInc * @param remoteFollowersDec */
@Serializable
data class ChartsUserFollowing200Response(

    @SerialName(value = "local.followings.total") val localFollowingsTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "local.followings.inc") val localFollowingsInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "local.followings.dec") val localFollowingsDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "local.followers.total") val localFollowersTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "local.followers.inc") val localFollowersInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "local.followers.dec") val localFollowersDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "remote.followings.total") val remoteFollowingsTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "remote.followings.inc") val remoteFollowingsInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "remote.followings.dec") val remoteFollowingsDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "remote.followers.total") val remoteFollowersTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "remote.followers.inc") val remoteFollowersInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "remote.followers.dec") val remoteFollowersDec: kotlin.collections.List<kotlin.Double>,

)
