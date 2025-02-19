package com.memije.pokedex.features.details.di

import com.memije.pokedex.core.network.ApiService
import com.memije.pokedex.features.details.data.repository.PokemonDetailRepositoryImpl
import com.memije.pokedex.features.details.domain.repository.PokemonDetailRepository
import com.memije.pokedex.features.details.domain.usecase.GetPokemonDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PokemonDetailModule {

    @Provides
    fun providePokemonDetailRepository(apiService: ApiService): PokemonDetailRepository {
        return PokemonDetailRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonDetailUseCase(repository: PokemonDetailRepository): GetPokemonDetailUseCase {
        return GetPokemonDetailUseCase(repository)
    }
}