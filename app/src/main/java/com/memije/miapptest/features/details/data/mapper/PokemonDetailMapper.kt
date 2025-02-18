package com.memije.miapptest.features.details.data.mapper

import com.memije.miapptest.features.details.data.model.PokemonDetailResponse
import com.memije.miapptest.features.details.domain.model.PokemonDetail

fun PokemonDetailResponse.toDomain(): PokemonDetail {
    return PokemonDetail(
        id = id,
        name = name,
        imageUrl = sprites.frontImage,
        height = height,
        weight = weight,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name }
    )
}
