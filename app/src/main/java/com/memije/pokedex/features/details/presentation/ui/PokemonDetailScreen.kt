package com.memije.pokedex.features.details.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.memije.pokedex.core.components.ErrorState
import com.memije.pokedex.core.components.LoadingState
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.details.domain.model.PokemonDetail
import com.memije.pokedex.features.details.presentation.viewmodel.PokemonDetailViewModel
import java.util.Locale

@Composable
fun PokemonDetailScreen(viewModel: PokemonDetailViewModel, pokemonName: String, navController: NavHostController) {

    val pokemonDetail by viewModel.pokemonDetail.collectAsState()

    LaunchedEffect(pokemonName) {
        viewModel.fetchPokemonDetail(pokemonName)
    }

    when (pokemonDetail) {
        is Response.Loading -> LoadingState()
        is Response.Success -> DetailContent((pokemonDetail as Response.Success<PokemonDetail>).data, navController)
        is Response.Error -> ErrorState(message = (pokemonDetail as Response.Error).message) {
            viewModel.fetchPokemonDetail(pokemonName)
        }
    }
}

@Composable
fun DetailContent(pokemon: PokemonDetail, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(pokemon.imageUrl),
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(150.dp).align(androidx.compose.ui.Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "ID: ${pokemon.id}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Nombre: ${pokemon.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }}", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Altura: ${pokemon.height}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Peso: ${pokemon.weight}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Tipos: ${pokemon.types.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        // Lista de habilidades del Pokémon
        pokemon.abilities.forEach { ability ->
            Text(
                text = ability,
                modifier = Modifier
                    .clickable { navController.navigate("abilityDetail/${ability}") }
                    .padding(8.dp)
            )
        }
    }
}