package com.xramos.mycomics.data.network.client

import com.xramos.mycomics.domain.model.model.CharacterModel

interface Repository {

    suspend fun searchCharacter(value: String): Result<List<CharacterModel>>

    suspend fun getCharacter(id: Int): Result<CharacterModel>
}