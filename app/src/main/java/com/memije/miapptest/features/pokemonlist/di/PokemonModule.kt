package com.memije.miapptest.features.pokemonlist.di

import com.memije.miapptest.core.network.ApiService
import com.memije.miapptest.features.pokemonlist.data.repository.PokemonRepositoryImpl
import com.memije.miapptest.features.pokemonlist.domain.repository.PokemonRepository
import com.memije.miapptest.features.pokemonlist.domain.usecase.GetPokemonUseCase
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
