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
 * @param mediaId
 * @param taggedUsers
 */
@Serializable
data class PostCreateTweetRequestVariablesMediaMediaEntitiesInner(
    @SerialName(value = "media_id")
    val mediaId: kotlin.String = "1111111111111111111",
    @SerialName(value = "tagged_users")
    val taggedUsers: kotlin.collections.List<String>,
)
