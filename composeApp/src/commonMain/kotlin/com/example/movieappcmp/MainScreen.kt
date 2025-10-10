package com.example.movieappcmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
                    )
            ) {
                AppNavGraph(navController)
            }
        }
}