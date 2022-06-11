package net.blakelee.composedestinationssample.main

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@NavGraph(default = true)
@RootNavGraph(start = true)
annotation class MainNavGraph(val start: Boolean = false)

@NavGraph
@MainNavGraph
annotation class SampleNavGraph(val start: Boolean = false)

@RootNavGraph
@NavGraph(default = false)
annotation class DisjointNavGraph(val start: Boolean = false)