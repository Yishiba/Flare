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
 * @param typename
 * @param itemType
 * @param userDisplayType
 * @param userResults
 * @param socialContext
 */
@Serializable
@SerialName("TimelineUser")
data class TimelineUser(
    @Contextual @SerialName(value = "__typename")
    val typename: TypeName,
    @Contextual @SerialName(value = "itemType")
    val itemType: ContentItemType,
    @SerialName(value = "userDisplayType")
    val userDisplayType: TimelineUser.UserDisplayType,
    @SerialName(value = "user_results")
    val userResults: UserResults,
    @SerialName(value = "SocialContext")
    val socialContext: SocialContext? = null,
) : ItemContentUnion {
    /**
     *
     *
     * Values: user,userDetailed,subscribableUser
     */
    @Serializable
    enum class UserDisplayType(val value: kotlin.String) {
        @SerialName(value = "User")
        user("User"),

        @SerialName(value = "UserDetailed")
        userDetailed("UserDetailed"),

        @SerialName(value = "SubscribableUser")
        subscribableUser("SubscribableUser"),
    }
}
