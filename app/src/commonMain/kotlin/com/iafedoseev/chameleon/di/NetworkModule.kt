package com.iafedoseev.chameleon.di

import com.iafedoseev.chameleon.network.ApiService
import com.iafedoseev.chameleon.network.createHttpClient
import org.koin.dsl.module

val networkModule = module {
    // HttpClient configuration
    single { createHttpClient() }
    
    // API Services
    single { ApiService(get()) }
}