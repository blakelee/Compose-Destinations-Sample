package net.blakelee.composedestinationssample.main.screens

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import net.blakelee.composedestinationssample.main.MainNavGraph

@MainNavGraph
@Destination
@Composable
fun ScreenC() {
    Surface(Modifier.fillMaxSize(), color = Color.Blue) {
        val navController = rememberNavController()

        DestinationsNavHost(
            navGraph = NavGraphs.sample,
            navController = navController,
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Composable
fun handleDeepLink(navController: NavController): Boolean {
    val context = LocalContext.current as Activity
    return runCatching {
        navController.handleDeepLink(context.intent).also { handled ->
            if (handled) context.intent = null
        }
    }.getOrDefault(false)
}