package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.Serializable

@Serializable
data class PowerResponse(
    val id: Int,
    val name: String = ""
)