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
 * @param antennaId * @param name * @param src * @param keywords * @param excludeKeywords * @param users * @param caseSensitive * @param withReplies * @param withFile * @param notify * @param userListId */
@Serializable
data class AntennasUpdateRequest(

    @SerialName(value = "antennaId") val antennaId: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "src") val src: AntennasUpdateRequest.Src,

    @SerialName(value = "keywords") val keywords: kotlin.collections.List<kotlin.collections.List<kotlin.String>>,

    @SerialName(value = "excludeKeywords") val excludeKeywords: kotlin.collections.List<kotlin.collections.List<kotlin.String>>,

    @SerialName(value = "users") val users: kotlin.collections.List<kotlin.String>,

    @SerialName(value = "caseSensitive") val caseSensitive: kotlin.Boolean,

    @SerialName(value = "withReplies") val withReplies: kotlin.Boolean,

    @SerialName(value = "withFile") val withFile: kotlin.Boolean,

    @SerialName(value = "notify") val notify: kotlin.Boolean,

    @SerialName(value = "userListId") val userListId: kotlin.String? = null,

) {

    /**
     * *
     * Values: Home,All,Users,List
     */
    @Serializable
    enum class Src(val value: kotlin.String) {
        @SerialName(value = "home")
        Home("home"),

        @SerialName(value = "all")
        All("all"),

        @SerialName(value = "users")
        Users("users"),

        @SerialName(value = "list")
        List("list"),
    }
}
