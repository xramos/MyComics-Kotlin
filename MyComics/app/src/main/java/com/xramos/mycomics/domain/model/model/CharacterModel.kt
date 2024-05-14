package com.xramos.mycomics.domain.model.model

import com.xramos.mycomics.domain.model.enumerations.Gender

data class CharacterModel(
    val id: Int = 0,
    val name: String = "",
    val realName: String? = "",
    val aliases: String? = "",
    val image: ImageModel = ImageModel(),
    val birth: String? = "",
    val deck: String? = "",
    val gender: Gender = Gender.OTHER,
    val origin: String = "",
    val powers: List<PowerModel> = emptyList()
)

fun CharacterModel.getPowers(): String {
    
    var result = ""

    powers.map {
        result = "$result, ${it.name}"
    }

    if (powers.isNotEmpty()) {
        result = result.removeRange(startIndex = 0, endIndex = 2)
    }
    
    return result
}