package com.example.movieappcmp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AdaptiveNavigationComponent(
    currentTopLevelDestination: Destination?,
    onItemClick: (Destination) -> Unit,
    content:@Composable () -> Unit = {}
) {
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            TopLevelNavMenuItem.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painter = painterResource(it.icon),
                            contentDescription = stringResource(it.title)
                        )
                    },
                    selected = currentTopLevelDestination == it.destination,
                    onClick = { onItemClick(it.destination) }
                )
            }
        },
    ){
        content()
    }
}