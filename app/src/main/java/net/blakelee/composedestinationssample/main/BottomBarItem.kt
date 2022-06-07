package net.blakelee.composedestinationssample.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.spec.Route
import net.blakelee.composedestinationssample.R
import net.blakelee.composedestinationssample.main.screens.NavGraphs
import net.blakelee.composedestinationssample.main.screens.destinations.ScreenADestination
import net.blakelee.composedestinationssample.main.screens.destinations.ScreenBDestination

@NavGraph(default = true)
annotation class MainNavGraph(val start: Boolean = false)

enum class BottomBarItem(
    val route: Route,
    @DrawableRes val icon: Int,
    @StringRes val label: Int
) {
    Home(ScreenADestination, R.drawable.ic_home, R.string.home),
    Middle(ScreenBDestination, R.drawable.ic_filter_2, R.string.middle),
    Navigation(NavGraphs.sample, R.drawable.ic_navigation, R.string.navigation)
}