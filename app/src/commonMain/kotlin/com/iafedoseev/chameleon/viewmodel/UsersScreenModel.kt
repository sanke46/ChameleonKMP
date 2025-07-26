package com.iafedoseev.chameleon.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.iafedoseev.chameleon.data.entity.User
import com.iafedoseev.chameleon.data.repository.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UsersScreenModel(
    private val userRepository: UserRepository
) : ScreenModel {
    
    val users: StateFlow<List<User>> = userRepository.getAllUsers()
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    
    fun addUser(name: String, email: String) {
        screenModelScope.launch {
            val user = User(
                name = name,
                email = email
            )
            userRepository.insertUser(user)
        }
    }
    
    fun deleteUser(user: User) {
        screenModelScope.launch {
            userRepository.deleteUser(user)
        }
    }
    
    fun deleteAllUsers() {
        screenModelScope.launch {
            userRepository.deleteAllUsers()
        }
    }
}