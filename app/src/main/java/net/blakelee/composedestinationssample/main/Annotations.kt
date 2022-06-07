package net.blakelee.composedestinationssample.main

import com.ramcosta.composedestinations.annotation.NavGraph

@NavGraph(default = true)
annotation class MainNavGraph(val start: Boolean = false)

@NavGraph
@MainNavGraph
annotation class SampleNavGraph(val start: Boolean = false)