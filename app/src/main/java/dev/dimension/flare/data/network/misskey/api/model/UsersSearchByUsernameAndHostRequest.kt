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

import kotlinx.serialization.Serializable

/**
 * *
 */
@Serializable

data class UsersSearchByUsernameAndHostRequest(
    val limit: Int? = null,
    val detail: Boolean? = null,
    val username: String? = null,
    val host: String? = null
)
