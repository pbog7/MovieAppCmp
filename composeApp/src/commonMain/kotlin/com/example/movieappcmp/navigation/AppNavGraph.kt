package com.example.movieappcmp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.HOME.route
    ) {
        composable(Destination.HOME.route) {
            HomeScreen({ navController.navigate(Destination.DETAILS.route) })
        }
        composable(Destination.FAVORITES.route) {
            FavoritesScreen()
        }

        composable(Destination.DETAILS.route) {
            DetailsScreen()
        }
    }
}

// Simple Composable Screens for testing navigation
@Composable
fun HomeScreen(navigateToDetails: (id: Int) -> Unit) {
    Column(
        Modifier.fillMaxSize().background(Color(0xFFC8E6C9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home Screen", style = MaterialTheme.typography.titleLarge, color = Color(0xFF00FF00))
        Button(onClick = { navigateToDetails(1) }) {
            Text("Go to Details")
        }
    }
}

@Composable
fun FavoritesScreen() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Search Screen", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun DetailsScreen() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Details Screen", style = MaterialTheme.typography.titleLarge)
    }
}
