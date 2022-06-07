package net.blakelee.composedestinationssample.main.screens.nestedscreens

import com.ramcosta.composedestinations.annotation.NavGraph
import net.blakelee.composedestinationssample.main.MainNavGraph

@NavGraph
@MainNavGraph
annotation class SampleNavGraph(val start: Boolean = false)