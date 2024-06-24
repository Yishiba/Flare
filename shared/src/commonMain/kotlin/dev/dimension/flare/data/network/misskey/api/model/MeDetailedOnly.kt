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
 * @param avatarId * @param bannerId * @param injectFeaturedNote * @param receiveAnnouncementEmail * @param alwaysMarkNsfw * @param autoSensitive * @param carefulBot * @param autoAcceptFollowed * @param noCrawle * @param preventAiLearning * @param isExplorable * @param isDeleted * @param twoFactorBackupCodes * @param hideOnlineStatus * @param hasUnreadSpecifiedNotes * @param hasUnreadMentions * @param hasUnreadAnnouncement * @param hasUnreadAntenna * @param hasUnreadNotification * @param hasPendingReceivedFollowRequest * @param mutedWords * @param mutedInstances * @param mutingNotificationTypes * @param emailNotificationTypes * @param email * @param emailVerified * @param securityKeysList */
@Serializable
internal data class MeDetailedOnly(
    @SerialName(value = "avatarId") val avatarId: kotlin.String? = null,
    @SerialName(value = "bannerId") val bannerId: kotlin.String? = null,
    @SerialName(value = "injectFeaturedNote") val injectFeaturedNote: kotlin.Boolean? = null,
    @SerialName(value = "receiveAnnouncementEmail") val receiveAnnouncementEmail: kotlin.Boolean? = null,
    @SerialName(value = "alwaysMarkNsfw") val alwaysMarkNsfw: kotlin.Boolean? = null,
    @SerialName(value = "autoSensitive") val autoSensitive: kotlin.Boolean? = null,
    @SerialName(value = "carefulBot") val carefulBot: kotlin.Boolean? = null,
    @SerialName(value = "autoAcceptFollowed") val autoAcceptFollowed: kotlin.Boolean? = null,
    @SerialName(value = "noCrawle") val noCrawle: kotlin.Boolean,
    @SerialName(value = "preventAiLearning") val preventAiLearning: kotlin.Boolean,
    @SerialName(value = "isExplorable") val isExplorable: kotlin.Boolean,
    @SerialName(value = "isDeleted") val isDeleted: kotlin.Boolean,
    @SerialName(value = "twoFactorBackupCodes") val twoFactorBackupCodes: MeDetailedOnly.TwoFactorBackupCodes,
    @SerialName(value = "hideOnlineStatus") val hideOnlineStatus: kotlin.Boolean,
    @SerialName(value = "hasUnreadSpecifiedNotes") val hasUnreadSpecifiedNotes: kotlin.Boolean,
    @SerialName(value = "hasUnreadMentions") val hasUnreadMentions: kotlin.Boolean,
    @SerialName(value = "hasUnreadAnnouncement") val hasUnreadAnnouncement: kotlin.Boolean,
    @SerialName(value = "hasUnreadAntenna") val hasUnreadAntenna: kotlin.Boolean,
    @SerialName(value = "hasUnreadNotification") val hasUnreadNotification: kotlin.Boolean,
    @SerialName(value = "hasPendingReceivedFollowRequest") val hasPendingReceivedFollowRequest: kotlin.Boolean,
    @SerialName(value = "mutedWords") val mutedWords: kotlin.collections.List<kotlin.collections.List<kotlin.String>>,
    @SerialName(value = "mutedInstances") val mutedInstances: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "mutingNotificationTypes") val mutingNotificationTypes: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "emailNotificationTypes") val emailNotificationTypes: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "email") val email: kotlin.String? = null,
    @SerialName(value = "emailVerified") val emailVerified: kotlin.Boolean? = null,
    @SerialName(value = "securityKeysList") val securityKeysList: kotlin.collections.List<kotlin.String>? = null,
) {
    /**
     * *
     * Values: Full,Partial,None
     */
    @Serializable
    enum class TwoFactorBackupCodes(
        val value: kotlin.String,
    ) {
        @SerialName(value = "full")
        Full("full"),

        @SerialName(value = "partial")
        Partial("partial"),

        @SerialName(value = "none")
        None("none"),
    }
}
