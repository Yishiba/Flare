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
 * @param registration * @param localTimeLine * @param globalTimeLine * @param hcaptcha * @param recaptcha * @param objectStorage * @param serviceWorker * @param miauth */
@Serializable

data class Meta200ResponseFeatures(

    @SerialName(value = "registration") @Required val registration: kotlin.Boolean,

    @SerialName(value = "localTimeLine") @Required val localTimeLine: kotlin.Boolean,

    @SerialName(value = "globalTimeLine") @Required val globalTimeLine: kotlin.Boolean,

    @SerialName(value = "hcaptcha") @Required val hcaptcha: kotlin.Boolean,

    @SerialName(value = "recaptcha") @Required val recaptcha: kotlin.Boolean,

    @SerialName(value = "objectStorage") @Required val objectStorage: kotlin.Boolean,

    @SerialName(value = "serviceWorker") @Required val serviceWorker: kotlin.Boolean,

    @SerialName(value = "miauth") val miauth: kotlin.Boolean? = true

)
