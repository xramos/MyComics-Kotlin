package com.xramos.mycomics.data.network.client

import com.xramos.mycomics.Constants
import com.xramos.mycomics.domain.model.servermodel.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NetworkAPI(private val client: HttpClient) {

    suspend fun searchCharacter(value: String): Result<List<CharacterResponse>> {

        return client.get("${Constants.BASE_URL}search/") {
            parameter("api_key", Constants.API_KEY)
            parameter("query", value)
            parameter("format", "json")
            parameter("field_list", "id,image,name,aliases,real_name,gender")
            parameter("resources", "character")
            parameter("limit", "100")
        }
    }

    suspend fun getCharacter(id: Int): Result<CharacterResponse> {

        return client.get("${Constants.BASE_URL}character/4005-$id") {
            parameter("api_key", Constants.API_KEY)
            parameter("format", "json")
            parameter("field_list", "id,image,name,aliases,real_name,birth,deck,gender,origin,powers")
        }
    }
}