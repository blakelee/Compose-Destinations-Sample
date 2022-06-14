package net.blakelee.composedestinationssample.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.utils.allDestinations
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import com.ramcosta.composedestinations.utils.startDestination
import net.blakelee.composedestinationssample.main.screens.NavGraphs

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentDestination =
        navController.currentDestinationAsState().value ?: NavGraphs.main.startDestination

    Scaffold(bottomBar = {
        AnimatedVisibility(
            visible = currentDestination in (NavGraphs.main.allDestinations),
            enter = fadeIn(),
            exit = fadeOut()
        ) { BottomBar(navController) }
    }) { paddingValues ->
        DestinationsNavHost(
            navGraph = NavGraphs.root,
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}