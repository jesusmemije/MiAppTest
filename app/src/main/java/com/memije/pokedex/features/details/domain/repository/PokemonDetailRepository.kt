package com.memije.pokedex.features.details.domain.repository

import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.details.domain.model.PokemonDetail

interface PokemonDetailRepository {
    suspend fun getPokemonDetail(name: String): Response<PokemonDetail>
}