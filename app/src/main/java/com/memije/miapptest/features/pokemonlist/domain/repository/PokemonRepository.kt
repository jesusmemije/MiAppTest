package com.memije.miapptest.features.pokemonlist.domain.repository

import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.pokemonlist.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(): Response<List<Pokemon>>
}
