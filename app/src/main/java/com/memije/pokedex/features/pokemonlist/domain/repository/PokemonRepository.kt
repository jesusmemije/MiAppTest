package com.memije.pokedex.features.pokemonlist.domain.repository

import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.pokemonlist.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(): Response<List<Pokemon>>
}
