package com.xramos.mycomics.domain.model.mapper

import com.xramos.mycomics.domain.model.enumerations.Gender
import com.xramos.mycomics.domain.model.model.CharacterModel
import com.xramos.mycomics.domain.model.model.PowerModel
import com.xramos.mycomics.domain.model.servermodel.CharacterResponse

fun CharacterResponse.toModel() : CharacterModel =
     CharacterModel(
         id = id,
         name = name,
         realName = realName,
         aliases = aliases,
         image = image.toModel(),
         birth = birth,
         deck = deck,
         gender = getGender(),
         origin = origin.name,
         powers = getPowers()
     )

fun CharacterResponse.getGender() : Gender =
    when (gender) {
        1 -> Gender.male
        2 -> Gender.female
        else -> Gender.other
    }

fun CharacterResponse.getPowers(): List<PowerModel> =
    powers.map { it.toModel() }