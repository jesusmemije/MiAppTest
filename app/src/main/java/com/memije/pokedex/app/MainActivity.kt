package com.memije.pokedex.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.memije.pokedex.app.navigation.NavigationGraph
import com.memije.pokedex.core.theme.PokeAppTheme
import com.memije.pokedex.features.abilities.presentation.viewmodel.AbilityViewModel
import com.memije.pokedex.features.details.presentation.viewmodel.PokemonDetailViewModel
import com.memije.pokedex.features.pokemonlist.presentation.viewmodel.PokemonViewModel
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
