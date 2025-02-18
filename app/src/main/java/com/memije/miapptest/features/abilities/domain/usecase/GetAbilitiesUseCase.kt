package com.memije.miapptest.features.abilities.domain.usecase

import com.memije.miapptest.features.abilities.domain.repository.AbilityRepository
import javax.inject.Inject

class GetAbilitiesUseCase @Inject constructor(
    private val repository: AbilityRepository
) {
    suspend operator fun invoke(name: String) = repository.getAbilityDetail(name)
}
