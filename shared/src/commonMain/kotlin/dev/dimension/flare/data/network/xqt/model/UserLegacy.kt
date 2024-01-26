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

package dev.dimension.flare.data.network.xqt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param blockedBy
 * @param blocking
 * @param canDm
 * @param canMediaTag
 * @param createdAt
 * @param defaultProfile
 * @param defaultProfileImage
 * @param description
 * @param entities
 * @param fastFollowersCount
 * @param favouritesCount
 * @param followersCount
 * @param friendsCount
 * @param hasCustomTimelines
 * @param isTranslator
 * @param listedCount
 * @param location
 * @param mediaCount
 * @param muting
 * @param name
 * @param normalFollowersCount
 * @param pinnedTweetIdsStr
 * @param possiblySensitive
 * @param profileImageUrlHttps
 * @param profileInterstitialType
 * @param screenName
 * @param statusesCount
 * @param translatorType
 * @param verified
 * @param wantRetweets
 * @param followRequestSent
 * @param followedBy
 * @param following
 * @param notifications
 * @param profileBannerExtensions
 * @param profileBannerUrl
 * @param profileImageExtensions
 * @param `protected`
 * @param url
 */
@Serializable
internal data class UserLegacy(
    @SerialName(value = "blocked_by")
    val blockedBy: kotlin.Boolean = false,
    @SerialName(value = "blocking")
    val blocking: kotlin.Boolean = false,
    @SerialName(value = "can_dm")
    val canDm: kotlin.Boolean = false,
    @SerialName(value = "can_media_tag")
    val canMediaTag: kotlin.Boolean = false,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "default_profile")
    val defaultProfile: kotlin.Boolean = false,
    @SerialName(value = "default_profile_image")
    val defaultProfileImage: kotlin.Boolean = false,
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    @SerialName(value = "entities")
    val entities: Entities,
    @SerialName(value = "fast_followers_count")
    val fastFollowersCount: kotlin.Int? = null,
    @SerialName(value = "favourites_count")
    val favouritesCount: kotlin.Int = 0,
    @SerialName(value = "followers_count")
    val followersCount: kotlin.Int = 0,
    @SerialName(value = "friends_count")
    val friendsCount: kotlin.Int = 0,
    @SerialName(value = "has_custom_timelines")
    val hasCustomTimelines: kotlin.Boolean = false,
    @SerialName(value = "is_translator")
    val isTranslator: kotlin.Boolean = false,
    @SerialName(value = "listed_count")
    val listedCount: kotlin.Int = 0,
    @SerialName(value = "location")
    val location: kotlin.String? = null,
    @SerialName(value = "media_count")
    val mediaCount: kotlin.Int = 0,
    @SerialName(value = "muting")
    val muting: kotlin.Boolean = false,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "normal_followers_count")
    val normalFollowersCount: kotlin.Int = 0,
    @SerialName(value = "pinned_tweet_ids_str")
    val pinnedTweetIdsStr: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "possibly_sensitive")
    val possiblySensitive: kotlin.Boolean = false,
    @SerialName(value = "profile_image_url_https")
    val profileImageUrlHttps: String,
    @SerialName(value = "profile_interstitial_type")
    val profileInterstitialType: kotlin.String? = null,
    @SerialName(value = "screen_name")
    val screenName: kotlin.String,
    @SerialName(value = "statuses_count")
    val statusesCount: kotlin.Int = 0,
    @SerialName(value = "translator_type")
    val translatorType: kotlin.String,
    @SerialName(value = "verified")
    val verified: kotlin.Boolean,
    @SerialName(value = "want_retweets")
    val wantRetweets: kotlin.Boolean = false,
    @SerialName(value = "follow_request_sent")
    val followRequestSent: kotlin.Boolean? = false,
    @SerialName(value = "followed_by")
    val followedBy: kotlin.Boolean? = false,
    @SerialName(value = "following")
    val following: kotlin.Boolean? = false,
    @SerialName(value = "notifications")
    val notifications: kotlin.Boolean? = false,
//    @SerialName(value = "profile_banner_extensions")
//    val profileBannerExtensions: kotlin.Any? = null,
    @SerialName(value = "profile_banner_url")
    val profileBannerUrl: String? = null,
//    @SerialName(value = "profile_image_extensions")
//    val profileImageExtensions: kotlin.Any? = null,
    @SerialName(value = "protected")
    val `protected`: kotlin.Boolean? = false,
    @SerialName(value = "url")
    val url: kotlin.String? = null,
    @SerialName(value = "verified_type")
    val verifiedType: kotlin.String? = null,
)
