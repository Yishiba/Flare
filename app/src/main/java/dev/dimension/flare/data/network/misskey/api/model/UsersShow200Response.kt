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

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param id * @param name * @param username * @param host The local host is represented with `null`.
 * @param avatarUrl * @param avatarBlurhash * @param onlineStatus * @param url * @param uri * @param movedToUri * @param alsoKnownAs * @param createdAt * @param updatedAt * @param lastFetchedAt * @param bannerUrl * @param bannerBlurhash * @param isLocked * @param isSilenced * @param isLimited * @param isSuspended * @param description * @param location * @param birthday * @param lang * @param fields * @param followersCount * @param followingCount * @param notesCount * @param pinnedNoteIds * @param pinnedNotes * @param pinnedPageId * @param pinnedPage * @param publicReactions * @param twoFactorEnabled * @param usePasswordLessLogin * @param securityKeys * @param avatarId * @param bannerId * @param injectFeaturedNote * @param receiveAnnouncementEmail * @param alwaysMarkNsfw * @param autoSensitive * @param carefulBot * @param autoAcceptFollowed * @param noCrawle * @param preventAiLearning * @param isExplorable * @param isDeleted * @param twoFactorBackupCodes * @param hideOnlineStatus * @param hasUnreadSpecifiedNotes * @param hasUnreadMentions * @param hasUnreadAnnouncement * @param hasUnreadAntenna * @param hasUnreadNotification * @param hasPendingReceivedFollowRequest * @param mutedWords * @param mutedInstances * @param mutingNotificationTypes * @param emailNotificationTypes * @param isAdmin * @param isModerator * @param isBot * @param isCat * @param isFollowing * @param isFollowed * @param hasPendingFollowRequestFromYou * @param hasPendingFollowRequestToYou * @param isBlocking * @param isBlocked * @param isMuted * @param isRenoteMuted * @param memo * @param email * @param emailVerified * @param securityKeysList */
@Serializable

data class UsersShow200Response(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String? = null,

    @SerialName(value = "username") val username: kotlin.String,

    /* The local host is represented with `null`. */
    @SerialName(value = "host") val host: kotlin.String? = null,

    @SerialName(value = "avatarUrl") val avatarUrl: kotlin.String? = null,

    @SerialName(value = "avatarBlurhash") val avatarBlurhash: kotlin.String? = null,

    @SerialName(value = "onlineStatus") val onlineStatus: UsersShow200Response.OnlineStatus? = null,

    @SerialName(value = "url") val url: kotlin.String? = null,

    @SerialName(value = "uri") val uri: kotlin.String? = null,

    @SerialName(value = "movedToUri") val movedToUri: kotlin.String? = null,

    @SerialName(value = "alsoKnownAs") val alsoKnownAs: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "updatedAt") val updatedAt: kotlin.String? = null,

    @SerialName(value = "lastFetchedAt") val lastFetchedAt: kotlin.String? = null,

    @SerialName(value = "bannerUrl") val bannerUrl: kotlin.String? = null,

    @SerialName(value = "bannerBlurhash") val bannerBlurhash: kotlin.String? = null,

    @SerialName(value = "isLocked") val isLocked: kotlin.Boolean,

    @SerialName(value = "isSilenced") val isSilenced: kotlin.Boolean,

    @SerialName(value = "isLimited") val isLimited: kotlin.Boolean,

    @SerialName(value = "isSuspended") val isSuspended: kotlin.Boolean,

    @SerialName(value = "description") val description: kotlin.String? = null,

    @SerialName(value = "location") val location: kotlin.String? = null,

    @SerialName(value = "birthday") val birthday: kotlin.String? = null,

    @SerialName(value = "lang") val lang: kotlin.String? = null,

    @SerialName(value = "fields") val fields: kotlin.collections.List<UserDetailedNotMeOnlyFieldsInner>,

    @SerialName(value = "followersCount") val followersCount: kotlin.Double,

    @SerialName(value = "followingCount") val followingCount: kotlin.Double,

    @SerialName(value = "notesCount") val notesCount: kotlin.Double,

    @SerialName(value = "pinnedNoteIds") val pinnedNoteIds: kotlin.collections.List<kotlin.String>,

    @SerialName(value = "pinnedNotes") val pinnedNotes: kotlin.collections.List<@Contextual Note>,

    @SerialName(value = "pinnedPageId") val pinnedPageId: kotlin.String? = null,

    @SerialName(value = "pinnedPage") val pinnedPage: Page,

    @SerialName(value = "publicReactions") val publicReactions: kotlin.Boolean,

    @SerialName(value = "twoFactorEnabled") val twoFactorEnabled: kotlin.Boolean = false,

    @SerialName(value = "usePasswordLessLogin") val usePasswordLessLogin: kotlin.Boolean = false,

    @SerialName(value = "securityKeys") val securityKeys: kotlin.Boolean = false,

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

    @SerialName(value = "twoFactorBackupCodes") val twoFactorBackupCodes: UsersShow200Response.TwoFactorBackupCodes,

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

    @SerialName(value = "isAdmin") val isAdmin: kotlin.Boolean? = false,

    @SerialName(value = "isModerator") val isModerator: kotlin.Boolean? = false,

    @SerialName(value = "isBot") val isBot: kotlin.Boolean? = null,

    @SerialName(value = "isCat") val isCat: kotlin.Boolean? = null,

    @SerialName(value = "isFollowing") val isFollowing: kotlin.Boolean? = null,

    @SerialName(value = "isFollowed") val isFollowed: kotlin.Boolean? = null,

    @SerialName(value = "hasPendingFollowRequestFromYou") val hasPendingFollowRequestFromYou: kotlin.Boolean? = null,

    @SerialName(value = "hasPendingFollowRequestToYou") val hasPendingFollowRequestToYou: kotlin.Boolean? = null,

    @SerialName(value = "isBlocking") val isBlocking: kotlin.Boolean? = null,

    @SerialName(value = "isBlocked") val isBlocked: kotlin.Boolean? = null,

    @SerialName(value = "isMuted") val isMuted: kotlin.Boolean? = null,

    @SerialName(value = "isRenoteMuted") val isRenoteMuted: kotlin.Boolean? = null,

    @SerialName(value = "memo") val memo: kotlin.String? = null,

    @SerialName(value = "email") val email: kotlin.String? = null,

    @SerialName(value = "emailVerified") val emailVerified: kotlin.Boolean? = null,

    @SerialName(value = "securityKeysList") val securityKeysList: kotlin.collections.List<kotlin.String>? = null

) {

    /**
     * *
     * Values: Unknown,Online,Active,Offline
     */
    @Serializable
    enum class OnlineStatus(val value: kotlin.String) {
        @SerialName(value = "unknown")
        Unknown("unknown"),

        @SerialName(value = "online")
        Online("online"),

        @SerialName(value = "active")
        Active("active"),

        @SerialName(value = "offline")
        Offline("offline");
    }

    /**
     * *
     * Values: Full,Partial,None
     */
    @Serializable
    enum class TwoFactorBackupCodes(val value: kotlin.String) {
        @SerialName(value = "full")
        Full("full"),

        @SerialName(value = "partial")
        Partial("partial"),

        @SerialName(value = "none")
        None("none");
    }
}
