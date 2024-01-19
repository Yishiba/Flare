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
 * @param darkRequest
 * @param media
 * @param semanticAnnotationIds
 * @param tweetText
 * @param reply
 */
@Serializable
data class PostCreateTweetRequestVariables(
    @SerialName(value = "dark_request")
    val darkRequest: kotlin.Boolean = false,
    @SerialName(value = "media")
    val media: PostCreateTweetRequestVariablesMedia,
    @SerialName(value = "semantic_annotation_ids")
    val semanticAnnotationIds: kotlin.collections.List<@Contextual kotlin.Any>,
    @SerialName(value = "tweet_text")
    val tweetText: kotlin.String = "test",
    @SerialName(value = "reply")
    val reply: PostCreateTweetRequestVariablesReply? = null,
)
