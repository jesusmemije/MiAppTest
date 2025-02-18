package com.memije.miapptest.features.details.domain.repository

import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.details.domain.model.PokemonDetail

interface PokemonDetailRepository {
    suspend fun getPokemonDetail(name: String): Response<PokemonDetail>
}