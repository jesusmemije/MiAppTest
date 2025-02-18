package com.memije.miapptest.features.abilities.data.mapper

import com.memije.miapptest.features.abilities.data.model.AbilityResponse
import com.memije.miapptest.features.abilities.domain.model.Ability

fun AbilityResponse.toDomain(): Ability {
    return Ability(
        id = id,
        name = name,
        effect = effectEntries.firstOrNull { it.language.name == "es" }?.effect ?: "No hay descripción disponible en español"
    )
}