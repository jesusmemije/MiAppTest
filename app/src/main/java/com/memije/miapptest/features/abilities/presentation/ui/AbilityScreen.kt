package com.memije.miapptest.features.abilities.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.miapptest.core.components.ErrorState
import com.memije.miapptest.core.components.LoadingState
import com.memije.miapptest.core.utils.Response
import com.memije.miapptest.features.abilities.domain.model.Ability
import com.memije.miapptest.features.abilities.presentation.viewmodel.AbilityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbilityScreen(
    viewModel: AbilityViewModel,
    abilityName: String,
    navController: NavHostController
) {
    val abilityDetail by viewModel.abilityDetail.collectAsState()

    LaunchedEffect(abilityName) {
        viewModel.fetchAbilityDetail(abilityName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = abilityName, fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (abilityDetail) {
                is Response.Loading -> LoadingState()
                is Response.Success -> {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(700)) + expandVertically(),
                        exit = fadeOut(animationSpec = tween(500))
                    ) {
                        AbilityContent((abilityDetail as? Response.Success<Ability>)?.data ?: Ability(0,"", ""))
                    }
                }
                is Response.Error -> ErrorState(
                    message = (abilityDetail as Response.Error).message
                ) { viewModel.fetchAbilityDetail(abilityName) }
            }
        }
    }
}

@Composable
fun AbilityContent(ability: Ability) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ability.name.uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = ability.effect,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
