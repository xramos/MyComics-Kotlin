package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.Serializable

@Serializable
data class OriginResponse(
    val id: Int = 0,
    val name: String = ""
)