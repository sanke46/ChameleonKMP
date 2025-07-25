package com.iafedoseev.chameleon.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

class ApiService(private val httpClient: HttpClient) {
    
    suspend fun getPosts(): List<Post> {
        return try {
            httpClient.get("https://jsonplaceholder.typicode.com/posts").body()
        } catch (e: Exception) {
            println("Error fetching posts: ${e.message}")
            emptyList()
        }
    }
    
    suspend fun getPost(id: Int): Post? {
        return try {
            httpClient.get("https://jsonplaceholder.typicode.com/posts/$id").body()
        } catch (e: Exception) {
            println("Error fetching post $id: ${e.message}")
            null
        }
    }
}