package net.blakelee.composedestinationssample.main.screens.disjointscreens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import net.blakelee.composedestinationssample.main.DisjointNavGraph

@DisjointNavGraph(start = true)
@Destination
@Composable
fun DisjointScreen() {
    Text(text = "Hello world")
}
