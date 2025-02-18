package com.memije.miapptest.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.memije.miapptest.app.navigation.NavigationGraph
import com.memije.miapptest.core.theme.PokeAppTheme
import com.memije.miapptest.features.abilities.presentation.viewmodel.AbilityViewModel
import com.memije.miapptest.features.details.presentation.viewmodel.PokemonDetailViewModel
import com.memije.miapptest.features.pokemonlist.presentation.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val pokemonViewModel: PokemonViewModel by viewModels()
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()
    private val abilityViewModel: AbilityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeAppTheme {
                val navController = rememberNavController()
                NavigationGraph(
                    navController = navController,
                    pokemonViewModel = pokemonViewModel,
                    abilityViewModel = abilityViewModel,
                    pokemonDetailViewModel = pokemonDetailViewModel
                )
            }
        }
    }
}
