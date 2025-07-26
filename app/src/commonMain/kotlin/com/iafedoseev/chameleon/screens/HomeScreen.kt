package com.iafedoseev.chameleon.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import chameleonkmp.app.generated.resources.Res
import chameleonkmp.app.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import com.iafedoseev.chameleon.Greeting

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val greeting: Greeting = koinInject()
        var showContent by remember { mutableStateOf(false) }
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to ChameleonKMP",
                style = MaterialTheme.typography.headlineMedium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            AnimatedVisibility(showContent) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Compose Multiplatform with Voyager Navigation!")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(greeting.greet())
                }
            }
        }
    }
}