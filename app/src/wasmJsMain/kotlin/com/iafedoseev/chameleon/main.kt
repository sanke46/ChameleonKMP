package com.iafedoseev.chameleon

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.koin.core.context.startKoin
import com.iafedoseev.chameleon.di.appModule
import com.iafedoseev.chameleon.di.networkModule

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // Initialize Koin for WASM
    startKoin {
        modules(appModule, networkModule)
    }
    
    ComposeViewport(document.body!!) {
        App()
    }
}