package com.iafedoseev.chameleon

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin
import com.iafedoseev.chameleon.di.appModule
import com.iafedoseev.chameleon.di.networkModule

fun MainViewController() = ComposeUIViewController { 
    // Initialize Koin for iOS
    startKoin {
        modules(appModule, networkModule)
    }
    
    App() 
}