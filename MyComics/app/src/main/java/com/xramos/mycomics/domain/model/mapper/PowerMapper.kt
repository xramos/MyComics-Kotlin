package com.xramos.mycomics.domain.model.mapper

import com.xramos.mycomics.domain.model.model.PowerModel
import com.xramos.mycomics.domain.model.servermodel.PowerResponse

fun PowerResponse.toModel() : PowerModel =
    PowerModel (
        id = id,
        name = name
    )