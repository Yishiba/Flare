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
 * @param maintainerName * @param maintainerEmail * @param version * @param name * @param uri * @param description * @param langs * @param tosUrl * @param repositoryUrl * @param feedbackUrl * @param defaultDarkTheme * @param defaultLightTheme * @param disableRegistration * @param cacheRemoteFiles * @param cacheRemoteSensitiveFiles * @param emailRequiredForSignup * @param enableHcaptcha * @param hcaptchaSiteKey * @param enableRecaptcha * @param recaptchaSiteKey * @param enableTurnstile * @param turnstileSiteKey * @param swPublickey * @param mascotImageUrl * @param bannerUrl * @param serverErrorImageUrl * @param infoImageUrl * @param notFoundImageUrl * @param iconUrl * @param maxNoteTextLength * @param ads * @param requireSetup * @param enableEmail * @param enableServiceWorker * @param translatorAvailable * @param proxyAccountName * @param mediaProxy * @param features */
@Serializable
data class Meta200Response(

    @SerialName(value = "maintainerName") val maintainerName: kotlin.String? = null,

    @SerialName(value = "maintainerEmail") val maintainerEmail: kotlin.String? = null,

    @SerialName(value = "version") val version: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "uri") val uri: kotlin.String,

    @SerialName(value = "description") val description: kotlin.String? = null,

    @SerialName(value = "langs") val langs: kotlin.collections.List<kotlin.String>,

    @SerialName(value = "tosUrl") val tosUrl: kotlin.String? = null,

    @SerialName(value = "repositoryUrl") val repositoryUrl: kotlin.String = "https://github.com/misskey-dev/misskey",

    @SerialName(value = "feedbackUrl") val feedbackUrl: kotlin.String = "https://github.com/misskey-dev/misskey/issues/new",

    @SerialName(value = "defaultDarkTheme") val defaultDarkTheme: kotlin.String? = null,

    @SerialName(value = "defaultLightTheme") val defaultLightTheme: kotlin.String? = null,

    @SerialName(value = "disableRegistration") val disableRegistration: kotlin.Boolean,

    @SerialName(value = "cacheRemoteFiles") val cacheRemoteFiles: kotlin.Boolean,

    @SerialName(value = "cacheRemoteSensitiveFiles") val cacheRemoteSensitiveFiles: kotlin.Boolean,

    @SerialName(value = "emailRequiredForSignup") val emailRequiredForSignup: kotlin.Boolean,

    @SerialName(value = "enableHcaptcha") val enableHcaptcha: kotlin.Boolean,

    @SerialName(value = "hcaptchaSiteKey") val hcaptchaSiteKey: kotlin.String? = null,

    @SerialName(value = "enableRecaptcha") val enableRecaptcha: kotlin.Boolean,

    @SerialName(value = "recaptchaSiteKey") val recaptchaSiteKey: kotlin.String? = null,

    @SerialName(value = "enableTurnstile") val enableTurnstile: kotlin.Boolean,

    @SerialName(value = "turnstileSiteKey") val turnstileSiteKey: kotlin.String? = null,

    @SerialName(value = "swPublickey") val swPublickey: kotlin.String? = null,

    @SerialName(value = "mascotImageUrl") val mascotImageUrl: kotlin.String = "/assets/ai.png",

    @SerialName(value = "bannerUrl") val bannerUrl: kotlin.String,

    @SerialName(value = "serverErrorImageUrl") val serverErrorImageUrl: kotlin.String? = null,

    @SerialName(value = "infoImageUrl") val infoImageUrl: kotlin.String? = null,

    @SerialName(value = "notFoundImageUrl") val notFoundImageUrl: kotlin.String? = null,

    @SerialName(value = "iconUrl") val iconUrl: kotlin.String? = null,

    @SerialName(value = "maxNoteTextLength") val maxNoteTextLength: kotlin.Double,

    @SerialName(value = "ads") val ads: kotlin.collections.List<Meta200ResponseAdsInner>,

    @SerialName(value = "requireSetup") val requireSetup: kotlin.Boolean,

    @SerialName(value = "enableEmail") val enableEmail: kotlin.Boolean,

    @SerialName(value = "enableServiceWorker") val enableServiceWorker: kotlin.Boolean,

    @SerialName(value = "translatorAvailable") val translatorAvailable: kotlin.Boolean,

    @SerialName(value = "proxyAccountName") val proxyAccountName: kotlin.String? = null,

    @SerialName(value = "mediaProxy") val mediaProxy: kotlin.String,

    @SerialName(value = "features") val features: Meta200ResponseFeatures? = null,

)
