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
 * @param aliases * @param name * @param category * @param url * @param isSensitive * @param roleIdsThatCanBeUsedThisEmojiAsReaction */
@Serializable
data class EmojiSimple(

    @SerialName(value = "aliases") val aliases: kotlin.collections.List<kotlin.String>,

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "category") val category: kotlin.String? = null,

    @SerialName(value = "url") val url: kotlin.String,

    @SerialName(value = "isSensitive") val isSensitive: kotlin.Boolean? = null,

    @SerialName(value = "roleIdsThatCanBeUsedThisEmojiAsReaction") val roleIdsThatCanBeUsedThisEmojiAsReaction: kotlin.collections.List<kotlin.String>? = null,

)
