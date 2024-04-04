package com.xramos.mycomics.domain.model.servermodel

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val id: Int,
    val name: String = "",
    @SerializedName("real_name")
    val realName: String = "",
    val aliases: String = "",
    val image: ImageResponse = ImageResponse(),
    val birth: String,
    val deck: String,
    val gender: Int,
    val origin: OriginResponse = OriginResponse(),
    val powers: List<PowerResponse> = emptyList()
)