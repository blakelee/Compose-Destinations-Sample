package net.blakelee.composedestinationssample.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import net.blakelee.composedestinationssample.main.screens.NavGraphs

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomBar(navController) }) { paddingValues ->

//        val currentDestination = navController.currentDestinationAsState().value
//        if (currentDestination is DeepLinkScreenDestination && !navController.isRouteOnBackStack(ScreenCDestination)) {
//            val args = currentDestination.argsFrom(navController.currentBackStackEntry!!)
//            navController.navigate(ScreenCDestination)
//            navController.navigate(DeepLinkScreenDestination.invoke(args))
//        }

        DestinationsNavHost(
            navGraph = NavGraphs.main,
            navController = navController,
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
        )
    }
}