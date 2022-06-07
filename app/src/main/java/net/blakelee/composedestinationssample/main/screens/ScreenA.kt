package net.blakelee.composedestinationssample.main.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ramcosta.composedestinations.annotation.Destination
import net.blakelee.composedestinationssample.main.MainNavGraph

@MainNavGraph(start = true)
@Destination
@Composable
fun ScreenA() {
    Surface(Modifier.fillMaxSize(), color = Color.Green) {}
}