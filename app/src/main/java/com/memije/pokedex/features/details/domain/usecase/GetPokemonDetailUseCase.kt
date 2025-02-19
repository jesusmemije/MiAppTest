package com.memije.pokedex.features.details.domain.usecase

import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.details.domain.model.PokemonDetail
import com.memije.pokedex.features.details.domain.repository.PokemonDetailRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonDetailRepository
) {
    suspend operator fun invoke(name: String): Response<PokemonDetail> = repository.getPokemonDetail(name)
}