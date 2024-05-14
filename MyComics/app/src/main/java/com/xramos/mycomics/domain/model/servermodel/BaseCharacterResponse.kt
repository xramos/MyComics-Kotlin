package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.Serializable

@Serializable
data class BaseCharacterResponse(
    val results: CharacterResponse?
)