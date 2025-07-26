package com.iafedoseev.chameleon

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.iafedoseev.chameleon.screens.MainScreen


@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(MainScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}