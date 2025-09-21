package com.example.movieappcmp.navigation

import movieappcmp.composeapp.generated.resources.Res
import movieappcmp.composeapp.generated.resources.favorite_icon
import movieappcmp.composeapp.generated.resources.favorites_menu_item_name
import movieappcmp.composeapp.generated.resources.home_icon
import movieappcmp.composeapp.generated.resources.home_menu_item_name
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class TopLevelNavMenuItem(
    val destination: Destination,
    val title: StringResource,
    val icon: DrawableResource
) {
    HOME(destination = Destination.HOME, Res.string.home_menu_item_name, Res.drawable.home_icon),
    FAVORITES(destination = Destination.FAVORITES, Res.string.favorites_menu_item_name, Res.drawable.favorite_icon),
}