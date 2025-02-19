package com.memije.pokedex.features.abilities.domain.repository

import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.abilities.domain.model.Ability

interface AbilityRepository {
    suspend fun getAbilityDetail(name: String): Response<Ability>
}