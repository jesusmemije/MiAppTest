package com.memije.pokedex.features.details.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("types") val types: List<TypeWrapper>,
    @SerializedName("abilities") val abilities: List<Ability>
)

data class Sprites(
    @SerializedName("front_default") val frontImage: String
)

data class TypeWrapper(
    @SerializedName("type") val type: Type
)

data class Type(
    @SerializedName("name") val name: String
)

data class Ability(
    @SerializedName("ability") val ability: Species
)

data class Species (
    val name: String
)