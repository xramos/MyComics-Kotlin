package com.xramos.mycomics.data.network.client

import com.xramos.mycomics.domain.model.mapper.toModel
import com.xramos.mycomics.domain.model.model.CharacterModel
import com.xramos.mycomics.domain.model.servermodel.CharacterResponse
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val networkApi: NetworkAPI): Repository {

    override suspend fun searchCharacter(value: String): Result<List<CharacterModel>> {

        return networkApi.searchCharacter(value).map {
            val characterModel: ArrayList<CharacterModel> = ArrayList()
            for (serverCharacter: CharacterResponse in it.results) {

                characterModel.add(serverCharacter.toModel())
            }

            return Result.success(characterModel)
        }
    }

    override suspend fun getCharacter(id: Int): Result<CharacterModel> {

        return networkApi.getCharacter(id).map {
            it.toModel()
        }
    }
}