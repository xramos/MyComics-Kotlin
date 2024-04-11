package com.xramos.mycomics.domain.model.servermodel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageResponse(
    @SerialName("small_url")
    val smallUrl: String = "",
    @SerialName("super_url")
    val superUrl: String = "",
    @SerialName("thumb_url")
    val thumbUrl: String = ""
)