package com.iafedoseev.chameleon.di

import com.iafedoseev.chameleon.Greeting
import org.koin.dsl.module

val appModule = module {
    // Example: Register the Greeting class as a single instance
    single { Greeting() }
}