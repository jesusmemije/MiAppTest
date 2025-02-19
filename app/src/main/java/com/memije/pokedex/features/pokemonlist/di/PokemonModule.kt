package com.memije.pokedex.features.pokemonlist.di

import com.memije.pokedex.core.network.ApiService
import com.memije.pokedex.features.pokemonlist.data.repository.PokemonRepositoryImpl
import com.memije.pokedex.features.pokemonlist.domain.repository.PokemonRepository
import com.memije.pokedex.features.pokemonlist.domain.usecase.GetPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Provides
    fun providePokemonRepository(apiService: ApiService): PokemonRepository {
        return PokemonRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonUseCase(repository: PokemonRepository): GetPokemonUseCase {
        return GetPokemonUseCase(repository)
    }
}
