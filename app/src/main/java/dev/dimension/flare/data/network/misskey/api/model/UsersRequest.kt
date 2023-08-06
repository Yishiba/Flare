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
 * @param limit * @param offset * @param sort * @param state * @param origin * @param hostname The local host is represented with `null`.
 */
@Serializable

data class UsersRequest(

    @SerialName(value = "limit") val limit: kotlin.Int? = 10,

    @SerialName(value = "offset") val offset: kotlin.Int? = 0,

    @SerialName(value = "sort") val sort: UsersRequest.Sort? = null,

    @SerialName(value = "state") val state: UsersRequest.State? = State.All,

    @SerialName(value = "origin") val origin: UsersRequest.Origin? = Origin.Local,

    /* The local host is represented with `null`. */
    @SerialName(value = "hostname") val hostname: kotlin.String? = null

) {

    /**
     * *
     * Values: PlusFollower,MinusFollower,PlusCreatedAt,MinusCreatedAt,PlusUpdatedAt,MinusUpdatedAt
     */
    @Serializable
    enum class Sort(val value: kotlin.String) {
        @SerialName(value = "+follower")
        PlusFollower("+follower"),

        @SerialName(value = "-follower")
        MinusFollower("-follower"),

        @SerialName(value = "+createdAt")
        PlusCreatedAt("+createdAt"),

        @SerialName(value = "-createdAt")
        MinusCreatedAt("-createdAt"),

        @SerialName(value = "+updatedAt")
        PlusUpdatedAt("+updatedAt"),

        @SerialName(value = "-updatedAt")
        MinusUpdatedAt("-updatedAt");
    }

    /**
     * *
     * Values: All,Alive
     */
    @Serializable
    enum class State(val value: kotlin.String) {
        @SerialName(value = "all")
        All("all"),

        @SerialName(value = "alive")
        Alive("alive");
    }

    /**
     * *
     * Values: Combined,Local,Remote
     */
    @Serializable
    enum class Origin(val value: kotlin.String) {
        @SerialName(value = "combined")
        Combined("combined"),

        @SerialName(value = "local")
        Local("local"),

        @SerialName(value = "remote")
        Remote("remote");
    }
}
