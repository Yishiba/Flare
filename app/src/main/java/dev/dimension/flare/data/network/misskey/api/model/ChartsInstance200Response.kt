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
 * @param requestsFailed * @param requestsSucceeded * @param requestsReceived * @param notesTotal * @param notesInc * @param notesDec * @param notesDiffsNormal * @param notesDiffsReply * @param notesDiffsRenote * @param notesDiffsWithFile * @param usersTotal * @param usersInc * @param usersDec * @param followingTotal * @param followingInc * @param followingDec * @param followersTotal * @param followersInc * @param followersDec * @param driveTotalFiles * @param driveIncFiles * @param driveDecFiles * @param driveIncUsage * @param driveDecUsage */
@Serializable

data class ChartsInstance200Response(

    @SerialName(value = "requests.failed") val requestsFailed: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "requests.succeeded") val requestsSucceeded: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "requests.received") val requestsReceived: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.total") val notesTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.inc") val notesInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.dec") val notesDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.diffs.normal") val notesDiffsNormal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.diffs.reply") val notesDiffsReply: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.diffs.renote") val notesDiffsRenote: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "notes.diffs.withFile") val notesDiffsWithFile: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "users.total") val usersTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "users.inc") val usersInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "users.dec") val usersDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "following.total") val followingTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "following.inc") val followingInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "following.dec") val followingDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "followers.total") val followersTotal: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "followers.inc") val followersInc: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "followers.dec") val followersDec: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "drive.totalFiles") val driveTotalFiles: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "drive.incFiles") val driveIncFiles: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "drive.decFiles") val driveDecFiles: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "drive.incUsage") val driveIncUsage: kotlin.collections.List<kotlin.Double>,

    @SerialName(value = "drive.decUsage") val driveDecUsage: kotlin.collections.List<kotlin.Double>

)
