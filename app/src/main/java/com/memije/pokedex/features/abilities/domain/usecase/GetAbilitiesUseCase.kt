package com.memije.pokedex.features.abilities.domain.usecase

import com.memije.pokedex.features.abilities.domain.repository.AbilityRepository
import javax.inject.Inject

class GetAbilitiesUseCase @Inject constructor(
    private val repository: AbilityRepository
) {
    suspend operator fun invoke(name: String) = repository.getAbilityDetail(name)
}
