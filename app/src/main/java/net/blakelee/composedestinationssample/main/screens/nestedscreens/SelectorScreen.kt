package net.blakelee.composedestinationssample.main.screens.nestedscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import net.blakelee.composedestinationssample.main.screens.destinations.DeepLinkScreenDestination

@SampleNavGraph(start = true)
@Destination
@Composable
fun SelectorScreen(navController: NavController) {
    Surface(
        color = Color.Magenta,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.padding(16.dp)) {
            Button(
                onClick = {
                    navController.navigate(DeepLinkScreenDestination.invoke(1337).route)
                },
                modifier = Modifier.wrapContentHeight()
            ) {
                Text(text = "Launch deep link")
            }
        }
    }
}