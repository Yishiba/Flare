package dev.dimension.flare.data.network

import de.jensklingenberg.ktorfit.converter.builtin.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.builtin.FlowConverterFactory
import dev.dimension.flare.common.JSON
import dev.dimension.flare.data.network.authorization.Authorization
import dev.dimension.flare.data.network.authorization.AuthorizationPlugin
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import okhttp3.logging.HttpLoggingInterceptor

internal fun ktorfit(
    baseUrl: String,
    authorization: Authorization? = null,
    config: HttpClientConfig<OkHttpConfig>.() -> Unit = {},
) = de.jensklingenberg.ktorfit.ktorfit {
    baseUrl(baseUrl)
    httpClient(
        ktorClient(authorization) {
            install(ContentNegotiation) {
                json(JSON)
            }
            config.invoke(this)
        },
    )
    converterFactories(
        FlowConverterFactory(),
        CallConverterFactory(),
    )
}

internal fun ktorClient(
    authorization: Authorization? = null,
    config: HttpClientConfig<OkHttpConfig>.() -> Unit = {},
) = HttpClient(OkHttp) {
    if (authorization != null) {
        install(AuthorizationPlugin) {
            this.authorization = authorization
        }
    }
    engine {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        addInterceptor(loggingInterceptor)
    }

    config.invoke(this)
//        install(Logging) {
//            logger = Logger.ANDROID
//            level = LogLevel.ALL
//        }
}
