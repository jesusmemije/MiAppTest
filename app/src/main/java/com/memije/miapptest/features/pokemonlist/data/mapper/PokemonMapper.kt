package com.memije.miapptest.features.pokemonlist.data.mapper

import com.memije.miapptest.features.pokemonlist.data.model.PokemonDto
import com.memije.miapptest.features.pokemonlist.domain.model.Pokemon

fun PokemonDto.toDomain(): Pokemon {
    val id = url.split("/").dropLast(1).lastOrNull()
    return Pokemon(
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    )
}