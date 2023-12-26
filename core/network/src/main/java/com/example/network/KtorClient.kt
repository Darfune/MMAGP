package com.example.network

import com.example.network.model.domain.giveaway.Giveaway
import com.example.network.model.domain.opengiveaway.OpenGiveaway
import com.example.network.model.domain.toGiveaway
import com.example.network.model.domain.toOpenGiveaway
import com.example.network.model.remote.giveaway.GiveawayDto
import com.example.network.model.remote.opengiveaway.OpenGiveawayDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {
    private val client = HttpClient(OkHttp) {
        defaultRequest { url("https://www.gamerpower.com/api/") }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getGiveawayById(id: Int): ApiOperation<Giveaway> = safeApiCall {
        client.get("giveaway?id=$id").body<GiveawayDto>().toGiveaway()
    }

    suspend fun getOpenGiveaway(
        sortBy: String?,
        platform: String?,
        type: String?,
    ): ApiOperation<List<Giveaway>> = safeApiCall {
        client.get("giveaways${buildUrlString(sortBy, platform, type)}")
            .body<List<GiveawayDto>>().map { it.toGiveaway() }
    }

    suspend fun getFilteredGiveaways(
        sortBy: String?,
        platform: String?,
        type: String?,
    ): ApiOperation<List<Giveaway>> = safeApiCall {
        client.get("filter${buildUrlString(sortBy, platform, type)}").body<List<GiveawayDto>>()
            .map { it.toGiveaway() }
    }

    private inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> {
        return try {
            ApiOperation.Success(data = apiCall())
        } catch (e: Exception) {
            ApiOperation.Failure(e)
        }
    }
}