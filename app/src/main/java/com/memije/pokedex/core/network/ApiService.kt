package com.memije.pokedex.core.network

import com.memije.pokedex.features.abilities.data.model.AbilityResponse
import com.memije.pokedex.features.details.data.model.PokemonDetailResponse
import com.memije.pokedex.features.pokemonlist.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 20, @Query("offset") offset: Int = 0): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetailResponse

    @GET("ability/{name}")
    suspend fun getAbilityDetail(@Path("name") name: String): AbilityResponse
}
