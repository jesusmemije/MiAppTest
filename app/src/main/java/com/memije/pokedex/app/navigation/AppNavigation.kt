package com.memije.pokedex.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.memije.pokedex.features.abilities.presentation.ui.AbilityScreen
import com.memije.pokedex.features.abilities.presentation.viewmodel.AbilityViewModel
import com.memije.pokedex.features.details.presentation.ui.PokemonDetailScreen
import com.memije.pokedex.features.details.presentation.viewmodel.PokemonDetailViewModel
import com.memije.pokedex.features.pokemonlist.presentation.ui.PokemonScreen
import com.memije.pokedex.features.pokemonlist.presentation.viewmodel.PokemonViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel,
    abilityViewModel: AbilityViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel
) {
    NavHost(navController, startDestination = "pokemonList") {
        composable("pokemonList") {
            PokemonScreen(viewModel = pokemonViewModel, navController = navController)
        }
        composable("pokemonDetail/{pokemonName}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: ""
            PokemonDetailScreen(viewModel = pokemonDetailViewModel, pokemonName = pokemonName, navController = navController)
        }
        composable("abilityDetail/{abilityName}") { backStackEntry ->
            val abilityName = backStackEntry.arguments?.getString("abilityName") ?: ""
            AbilityScreen(viewModel = abilityViewModel, abilityName = abilityName, navController = navController)
        }
    }
}
