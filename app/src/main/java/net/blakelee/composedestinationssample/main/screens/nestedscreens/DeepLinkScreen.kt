package net.blakelee.composedestinationssample.main.screens.nestedscreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import net.blakelee.composedestinationssample.main.SampleNavGraph

@SampleNavGraph
@Destination(deepLinks = [DeepLink(uriPattern = "https://example.com/{id}")])
@Composable
fun DeepLinkScreen(id: Int) {

    Surface(
        color = Color.Red,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Deep link received with result: $id")
    }
}