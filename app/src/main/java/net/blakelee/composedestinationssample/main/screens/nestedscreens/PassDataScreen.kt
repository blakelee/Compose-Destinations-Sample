package net.blakelee.composedestinationssample.main.screens.nestedscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import net.blakelee.composedestinationssample.main.SampleNavGraph

@SampleNavGraph
@Destination
@Composable
fun PassDataScreen(data: Int, navController: NavController) {
    Surface(
        color = Color.Blue,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = data.toString())
            Spacer(modifier = Modifier.size(8.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Go back")
            }
        }
    }
}