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

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param place * @param url * @param imageUrl */
@Serializable

data class Meta200ResponseAdsInner(

    @SerialName(value = "place") @Required val place: kotlin.String,

    @SerialName(value = "url") @Required val url: kotlin.String,

    @SerialName(value = "imageUrl") @Required val imageUrl: kotlin.String

)
