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

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

/**
 *
 *
 * @param typename
 * @param editControl
 * @param isTranslatable
 * @param restId
 * @param views
 * @param tweet
 * @param birdwatchPivot
 * @param card
 * @param core
 * @param editPrespective
 * @param legacy
 * @param noteTweet
 * @param quickPromoteEligibility
 * @param quotedStatusResult
 * @param source
 * @param unmentionData
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("__typename")
internal sealed interface TweetUnion {
//    @Contextual
//    @SerialName(value = "__typename")
//    val typename: TypeName
//
//    @SerialName(value = "edit_control")
//    val editControl: TweetEditControl
//
//    @SerialName(value = "is_translatable")
//    val isTranslatable: kotlin.Boolean
//
//    @SerialName(value = "rest_id")
//    val restId: kotlin.String
//
//    @SerialName(value = "views")
//    val views: TweetView
//
//    @SerialName(value = "tweet")
//    val tweet: Tweet
//
//    @SerialName(value = "birdwatch_pivot")
//    val birdwatchPivot: BirdwatchPivot?
//
//    @SerialName(value = "card")
//    val card: TweetCard?
//
//    @SerialName(value = "core")
//    val core: UserResultCore?
//
//    @SerialName(value = "edit_prespective")
//    val editPrespective: TweetEditPrespective?
//
//    @SerialName(value = "legacy")
//    val legacy: TweetLegacy?
//
//    @SerialName(value = "note_tweet")
//    val noteTweet: NoteTweet?
//
//    @Contextual
//    @SerialName(value = "quick_promote_eligibility")
//    val quickPromoteEligibility: kotlin.Any?
//
//    @SerialName(value = "quoted_status_result")
//    val quotedStatusResult: ItemResult?
//
//    @SerialName(value = "source")
//    val source: kotlin.String?
//
//    @Contextual
//    @SerialName(value = "unmention_data")
//    val unmentionData: kotlin.collections.Map<kotlin.String, kotlin.Any>?
}
