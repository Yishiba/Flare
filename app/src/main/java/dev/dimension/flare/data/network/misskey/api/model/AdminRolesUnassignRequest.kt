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
 * @param roleId * @param userId */
@Serializable

data class AdminRolesUnassignRequest(

    @SerialName(value = "roleId") @Required val roleId: kotlin.String,

    @SerialName(value = "userId") @Required val userId: kotlin.String

)
