package net.blakelee.composedestinationssample.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import net.blakelee.composedestinationssample.R
import net.blakelee.composedestinationssample.main.screens.destinations.ScreenADestination
import net.blakelee.composedestinationssample.main.screens.destinations.ScreenBDestination
import net.blakelee.composedestinationssample.main.screens.destinations.ScreenCDestination

@NavGraph(default = true)
annotation class MainNavGraph(val start: Boolean = false)

enum class BottomBarItem(
    val direction: DirectionDestinationSpec,
    @DrawableRes val icon: Int,
    @StringRes val label: Int
) {
    Home(ScreenADestination, R.drawable.ic_home, R.string.home),
    Middle(ScreenBDestination, R.drawable.ic_filter_2, R.string.middle),
    Navigation(ScreenCDestination, R.drawable.ic_navigation, R.string.navigation)
}