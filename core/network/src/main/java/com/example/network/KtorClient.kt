package com.example.network

import com.example.network.model.giveaway.Giveaway
import com.example.network.model.opengiveaway.OpenGiveaway
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
import java.lang.Exception

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
        client.get("giveaway?id=$id").body()
    }

    suspend fun getOpenGiveaway(
        sortBy: String?,
        platform: String?,
        type: String?,
    ): ApiOperation<List<OpenGiveaway>> = safeApiCall {
        client.get("giveaways${buildUrlString(sortBy, platform, type)}").body()
    }

    suspend fun getFilteredGiveaways(
        sortBy: String?,
        platform: String?,
        type: String?,
    ): ApiOperation<List<OpenGiveaway>> = safeApiCall {
        client.get("filter${buildUrlString(sortBy, platform, type)}").body()
    }

    private inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> {
        return try {
            ApiOperation.Success(data = apiCall())
        } catch (e: Exception) {
            ApiOperation.Failure(e)
        }
    }
}

sealed interface ApiOperation<T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure<T>(val exception: Exception) : ApiOperation<T>

    fun onSuccess(block: (T) -> Unit): ApiOperation<T> {
        if (this is Success) block(data)
        return this
    }

    fun onFailure(block: (Exception) -> Unit): ApiOperation<T> {
        if (this is Failure) block(exception)
        return this
    }

}
