package com.memije.miapptest.features.abilities.domain.repository

import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.abilities.domain.model.Ability

interface AbilityRepository {
    suspend fun getAbilityDetail(name: String): Response<Ability>
}