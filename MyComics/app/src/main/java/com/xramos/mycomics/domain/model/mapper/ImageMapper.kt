package com.xramos.mycomics.domain.model.mapper

import com.xramos.mycomics.domain.model.model.ImageModel
import com.xramos.mycomics.domain.model.servermodel.ImageResponse

fun ImageResponse.toModel(): ImageModel =
    ImageModel(
        smallUrl = smallUrl,
        superUrl = superUrl,
        thumbUrl = thumbUrl
    )