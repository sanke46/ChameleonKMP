package com.iafedoseev.chameleon

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.context.startKoin
import com.iafedoseev.chameleon.di.appModule

fun main() = application {
    // Initialize Koin
    startKoin {
        modules(appModule)
    }
    
    Window(
        onCloseRequest = ::exitApplication,
        title = "ChameleonKMP",
    ) {
        App()
    }
}