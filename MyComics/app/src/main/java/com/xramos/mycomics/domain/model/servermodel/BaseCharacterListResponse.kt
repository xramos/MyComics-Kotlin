package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.Serializable

@Serializable
data class BaseCharacterListResponse(
    val results: List<CharacterResponse> = emptyList()
)