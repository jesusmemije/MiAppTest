package com.memije.pokedex.features.pokemonlist.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results") val results: List<PokemonDto>
)

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)