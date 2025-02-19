package com.memije.pokedex.features.abilities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.abilities.domain.model.Ability
import com.memije.pokedex.features.abilities.domain.usecase.GetAbilitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AbilityViewModel @Inject constructor(
    private val getAbilitiesUseCase: GetAbilitiesUseCase
) : ViewModel() {

    private val _abilityDetail = MutableStateFlow<Response<Ability>>(Response.Loading)
    val abilityDetail: StateFlow<Response<Ability>> = _abilityDetail

    fun fetchAbilityDetail(name: String) {
        viewModelScope.launch {
            _abilityDetail.value = getAbilitiesUseCase(name)
        }
    }
}
