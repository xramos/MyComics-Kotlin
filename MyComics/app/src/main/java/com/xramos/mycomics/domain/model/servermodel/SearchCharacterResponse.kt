package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.Serializable

@Serializable
data class SearchCharacterResponse(
    val results: List<CharacterResponse> = emptyList()
)