package com.memije.miapptest.features.pokemonlist.data.repository

import com.memije.miapptest.core.network.ApiService
import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.pokemonlist.data.mapper.toDomain
import com.memije.miapptest.features.pokemonlist.domain.model.Pokemon
import com.memije.miapptest.features.pokemonlist.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonRepository {

    override suspend fun getPokemonList(): Response<List<Pokemon>> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonList() }
            Response.Success(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "Error desconocido")
        }
    }
}
