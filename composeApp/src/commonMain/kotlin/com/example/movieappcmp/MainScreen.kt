package com.example.movieappcmp

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movieappcmp.navigation.AdaptiveNavigationComponent
import com.example.movieappcmp.navigation.AppNavGraph
import com.example.movieappcmp.navigation.TopLevelNavMenuItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()


    val currentTopLevel = TopLevelNavMenuItem.entries
        .firstOrNull { item ->
            navController.currentBackStackEntryAsState().value
                ?.destination
                ?.hierarchy
                ?.any { it.route == item.destination.route } == true
        }


    AdaptiveNavigationComponent(
        currentTopLevelDestination = currentTopLevel?.destination,
        onItemClick = { destination ->
            navController.navigate(destination.route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(navController.graph.startDestinationId) { saveState = true }
            }
        }
    ) {
        AppNavGraph(navController)
    }
}