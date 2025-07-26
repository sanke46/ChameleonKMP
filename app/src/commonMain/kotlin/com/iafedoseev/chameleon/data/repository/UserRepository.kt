package com.iafedoseev.chameleon.data.repository

import com.iafedoseev.chameleon.data.dao.UserDao
import com.iafedoseev.chameleon.data.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    
    suspend fun getUserById(id: Long): User? = userDao.getUserById(id)
    
    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
    
    suspend fun insertUser(user: User): Long = userDao.insertUser(user)
    
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    
    suspend fun deleteUserById(id: Long) = userDao.deleteUserById(id)
    
    suspend fun deleteAllUsers() = userDao.deleteAllUsers()
}