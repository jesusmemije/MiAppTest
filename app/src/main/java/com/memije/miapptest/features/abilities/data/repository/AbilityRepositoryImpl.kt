package com.memije.miapptest.features.abilities.data.repository

import android.util.Log
import com.memije.miapptest.core.network.ApiService
import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.abilities.data.mapper.toDomain
import com.memije.miapptest.features.abilities.domain.model.Ability
import com.memije.miapptest.features.abilities.domain.repository.AbilityRepository
import javax.inject.Inject

class AbilityRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AbilityRepository {

    override suspend fun getAbilityDetail(name: String): Response<Ability> {
        return try {
            val response = apiService.getAbilityDetail(name)

            // DEBUG: Imprimir las traducciones disponibles
            response.effectEntries.forEach { entry ->
                Log.d("AbilityTranslation", "Idioma: ${entry.language.name}, Descripción: ${entry.effect}")
            }

            Response.Success(response.toDomain())
        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "Error al obtener detalles de la habilidad")
        }
    }
}
