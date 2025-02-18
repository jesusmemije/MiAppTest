package com.memije.miapptest.features.pokemonlist.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.memije.miapptest.core.components.ErrorState
import com.memije.miapptest.core.components.LoadingState
import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.pokemonlist.domain.model.Pokemon
import com.memije.miapptest.features.pokemonlist.presentation.viewmodel.PokemonViewModel

@Composable
fun PokemonScreen(viewModel: PokemonViewModel, navController: NavHostController) {
    val pokemonList by viewModel.pokemonList.collectAsState()

    when (pokemonList) {
        is Response.Loading -> LoadingState()
        is Response.Success -> PokemonList((pokemonList as Response.Success<List<Pokemon>>).data, navController)
        is Response.Error -> ErrorState(message = (pokemonList as Response.Error).message) {
            viewModel.fetchPokemon()
        }
    }
}

@Composable
fun PokemonList(pokemonList: List<Pokemon>, navController: NavController) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            Row(modifier = Modifier.padding(8.dp).clickable { navController.navigate("pokemonDetail/${pokemon.name}") }) {
                Image(
                    painter = rememberAsyncImagePainter(pokemon.imageUrl),
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = pokemon.name)
            }
        }
    }
}
