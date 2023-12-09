package dev.dimension.flare.data.network.nodeinfo

import dev.dimension.flare.data.network.ktorClient
import dev.dimension.flare.data.network.nodeinfo.model.NodeInfo
import dev.dimension.flare.data.network.nodeinfo.model.Schema10
import dev.dimension.flare.data.network.nodeinfo.model.Schema11
import dev.dimension.flare.data.network.nodeinfo.model.Schema20
import dev.dimension.flare.data.network.nodeinfo.model.Schema21
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol

internal data object NodeInfoService {
    private val supportedSchemas = listOf(
        "http://nodeinfo.diaspora.software/ns/schema/1.0",
        "http://nodeinfo.diaspora.software/ns/schema/1.1",
        "http://nodeinfo.diaspora.software/ns/schema/2.0",
        "http://nodeinfo.diaspora.software/ns/schema/2.1",
    )
    suspend fun fetchNodeInfo(
        instance: String,
    ): String {
        val response = ktorClient().get(
            URLBuilder(
                protocol = URLProtocol.HTTPS,
                host = instance,
                fragment = ".well-known/nodeinfo"
            ).build()
        ).body<NodeInfo>()
        return response.links.filter { it.rel in supportedSchemas }.map {
            when (it.rel) {
                "http://nodeinfo.diaspora.software/ns/schema/1.0" -> ktorClient().get(it.href).body<Schema10.Coordinate>().software.name.value
                "http://nodeinfo.diaspora.software/ns/schema/1.1" -> ktorClient().get(it.href).body<Schema11.Coordinate>().software.name.value
                "http://nodeinfo.diaspora.software/ns/schema/2.0" -> ktorClient().get(it.href).body<Schema20.Coordinate>().software.name
                "http://nodeinfo.diaspora.software/ns/schema/2.1" -> ktorClient().get(it.href).body<Schema21.Coordinate>().software.name
                else -> throw IllegalArgumentException("Unsupported schema: ${it.rel}")
            }
        }.first()
    }
}