package net.blakelee.composedestinationssample.main.screens.nestedscreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.navigate
import net.blakelee.composedestinationssample.main.SampleNavGraph
import net.blakelee.composedestinationssample.main.screens.destinations.DeepLinkScreenDestination
import net.blakelee.composedestinationssample.main.screens.destinations.PassDataScreenDestination

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

            Spacer(modifier = Modifier.size(8.dp))

            var passValue by remember { mutableStateOf("5000") }
            OutlinedTextField(
                value = passValue,
                onValueChange = { passValue = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(onClick = {
                navController.navigate(PassDataScreenDestination.invoke(passValue.toInt()))
            }) {
                Text("Pass Data")
            }

        }
    }
}