package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String = "",
    @SerialName("real_name")
    val realName: String? = "",
    val aliases: String? = "",
    val image: ImageResponse = ImageResponse(),
    val birth: String? = "",
    val deck: String? = "",
    val gender: Int,
    val origin: OriginResponse = OriginResponse(),
    val powers: List<PowerResponse> = emptyList()
)