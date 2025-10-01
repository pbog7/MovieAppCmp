package com.example.core.extensions

import androidx.navigation.NavController

fun NavController.navigateTopLevel(
    destinationRoute: String
) {
    val currentRoute = this.currentDestination?.route
    if (currentRoute != destinationRoute) {
        this.navigate(destinationRoute) {
            launchSingleTop = true
            restoreState = true
            popUpTo(this@navigateTopLevel.graph.startDestinationId) {
                saveState = true
            }
        }
    }
}
