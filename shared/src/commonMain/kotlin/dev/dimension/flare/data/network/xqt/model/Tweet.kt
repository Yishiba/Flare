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

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param editControl
 * @param isTranslatable
 * @param restId
 * @param views
 * @param typename
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
@Serializable
data class Tweet(
    @SerialName(value = "edit_control")
    val editControl: TweetEditControl,
    @SerialName(value = "is_translatable")
    val isTranslatable: kotlin.Boolean = false,
    @SerialName(value = "rest_id")
    val restId: kotlin.String,
    @SerialName(value = "views")
    val views: TweetView,
    @Contextual @SerialName(value = "__typename")
    val typename: TypeName? = null,
    @SerialName(value = "birdwatch_pivot")
    val birdwatchPivot: BirdwatchPivot? = null,
    @SerialName(value = "card")
    val card: TweetCard? = null,
    @SerialName(value = "core")
    val core: UserResultCore? = null,
    @SerialName(value = "edit_prespective")
    val editPrespective: TweetEditPrespective? = null,
    @SerialName(value = "legacy")
    val legacy: TweetLegacy? = null,
    @SerialName(value = "note_tweet")
    val noteTweet: NoteTweet? = null,
    @Contextual @SerialName(value = "quick_promote_eligibility")
    val quickPromoteEligibility: kotlin.Any? = null,
    @SerialName(value = "quoted_status_result")
    val quotedStatusResult: ItemResult? = null,
    @SerialName(value = "source")
    val source: kotlin.String? = null,
    @Contextual @SerialName(value = "unmention_data")
    val unmentionData: kotlin.collections.Map<kotlin.String, kotlin.Any>? = null,
)
