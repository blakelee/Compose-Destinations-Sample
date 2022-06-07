package net.blakelee.composedestinationssample.main

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import net.blakelee.composedestinationssample.main.screens.NavGraphs
import net.blakelee.composedestinationssample.main.screens.appDestination
import net.blakelee.composedestinationssample.ui.theme.darkTan
import net.blakelee.composedestinationssample.ui.theme.tan

@Composable
fun BottomBar(navController: NavHostController) {

    NavigationBar(contentColor = darkTan, containerColor = tan) {
        BottomBarItem.values().forEachIndexed { index, destination ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(destination.direction)
            val currentDestination = navController.currentBackStackEntryAsState().value
            val isSelected = currentDestination?.appDestination() == destination.direction

            NavigationBarItem(
                selected = currentDestination?.appDestination() == destination.direction,
                onClick = {

                    if (isCurrentDestOnBackStack) {
                        // When we click again on a bottom bar item and it was already selected
                        // we want to pop the back stack until the initial destination of this bottom bar item
                        navController.popBackStack(destination.direction, false)
                        return@NavigationBarItem
                    }

                    navController.navigate(destination.direction) {
                        // Pop up to the root of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(NavGraphs.main) {
                            saveState = true
                            inclusive = true
                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    BadgedBox(badge = {
                        if (isSelected && index > 0) {
                            Badge { Text(index.toString()) }
                        }
                    }) {
                        Icon(
                            painterResource(destination.icon),
                            stringResource(destination.label)
                        )
                    }
                },
                label = { Text(stringResource(destination.label)) },
                colors = mainNavigationBarItemColors()
            )
        }
    }
}

@Composable
fun mainNavigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = Color(0xFF1C1C07),
    selectedTextColor = Color(0xFF24231F),
    unselectedIconColor = Color(0xFF484638),
    unselectedTextColor = Color(0xFF484638),
    indicatorColor = Color(0xFFE7E5C0)
)

fun NavOptionsBuilder.popUpToTop(navController: NavController) {
    popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
        inclusive = true
    }
}