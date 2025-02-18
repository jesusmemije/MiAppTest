package com.memije.miapptest.features.abilities.di

import com.memije.miapptest.core.network.ApiService
import com.memije.miapptest.features.abilities.data.repository.AbilityRepositoryImpl
import com.memije.miapptest.features.abilities.domain.repository.AbilityRepository
import com.memije.miapptest.features.abilities.domain.usecase.GetAbilitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AbilityModule {

    @Provides
    fun provideAbilityRepository(apiService: ApiService): AbilityRepository {
        return AbilityRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetAbilitiesUseCase(repository: AbilityRepository): GetAbilitiesUseCase {
        return GetAbilitiesUseCase(repository)
    }
}
