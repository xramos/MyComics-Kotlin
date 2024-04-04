package com.xramos.mycomics.domain.model.servermodel

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("small_url")
    val smallUrl: String = "",
    @SerializedName("super_url")
    val superUrl: String = "",
    @SerializedName("thumb_url")
    val thumbUrl: String = ""
)