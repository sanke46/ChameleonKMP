package com.iafedoseev.chameleon.di

import com.iafedoseev.chameleon.data.database.AppDatabase
import com.iafedoseev.chameleon.data.database.getDatabase
import com.iafedoseev.chameleon.data.repository.UserRepository
import com.iafedoseev.chameleon.viewmodel.UsersScreenModel
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> { getDatabase() }
    single { get<AppDatabase>().userDao() }
    single { UserRepository(get()) }
    factory { UsersScreenModel(get()) }
}