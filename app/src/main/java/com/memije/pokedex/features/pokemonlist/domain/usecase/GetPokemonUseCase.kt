package com.memije.pokedex.features.pokemonlist.domain.usecase

import com.memije.pokedex.features.pokemonlist.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = repository.getPokemonList()
}
