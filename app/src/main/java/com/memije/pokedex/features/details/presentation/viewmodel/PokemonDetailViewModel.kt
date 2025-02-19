package com.memije.pokedex.features.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.details.domain.model.PokemonDetail
import com.memije.pokedex.features.details.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    private val _pokemonDetail = MutableStateFlow<Response<PokemonDetail>>(Response.Loading)
    val pokemonDetail: StateFlow<Response<PokemonDetail>> = _pokemonDetail

    fun fetchPokemonDetail(name: String) {
        viewModelScope.launch {
            _pokemonDetail.value = getPokemonDetailUseCase(name)
        }
    }
}