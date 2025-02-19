package com.memije.pokedex.features.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.pokemonlist.domain.model.Pokemon
import com.memije.pokedex.features.pokemonlist.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<Response<List<Pokemon>>>(Response.Loading)
    val pokemonList: StateFlow<Response<List<Pokemon>>> = _pokemonList

    init {
        fetchPokemon()
    }

    fun fetchPokemon() {
        viewModelScope.launch {
            _pokemonList.value = getPokemonUseCase()
        }
    }
}
