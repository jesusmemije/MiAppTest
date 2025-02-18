package com.memije.miapptest.features.details.data.repository

import com.memije.miapptest.core.network.ApiService
import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.details.data.mapper.toDomain
import com.memije.miapptest.features.details.domain.repository.PokemonDetailRepository
import com.memije.miapptest.features.details.domain.model.PokemonDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonDetailRepository {

    override suspend fun getPokemonDetail(name: String): Response<PokemonDetail> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonDetail(name) }
            Response.Success(response.toDomain())
        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "Error al obtener detalles")
        }
    }
}