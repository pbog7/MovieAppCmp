package com.example.movieappcmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core.extensions.navigateTopLevel
import com.example.movieappcmp.navigation.AdaptiveNavigationComponent
import com.example.movieappcmp.navigation.AppNavGraph
import com.example.movieappcmp.navigation.TopLevelNavMenuItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    // Collect this once, not inside firstOrNull
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    // Use remember to avoid recalculating unnecessarily
    val currentTopLevel = remember(currentDestination) {
        TopLevelNavMenuItem.entries.firstOrNull { item ->
            currentDestination?.hierarchy?.any { it.route == item.destination.route } == true
        }
    }

    AdaptiveNavigationComponent(
        currentTopLevelDestination = currentTopLevel?.destination,
        onItemClick = { destination ->
            navController.navigateTopLevel(destination.route)
        }
    ) {
        AppNavGraph(navController)
    }
}