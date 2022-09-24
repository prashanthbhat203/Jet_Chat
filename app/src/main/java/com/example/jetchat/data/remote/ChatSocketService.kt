package com.example.jetchat.data.remote

import com.example.jetchat.domain.model.Message
import com.example.jetchat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String,
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

     suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://192.168.102.204:8080"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket: Endpoints("${BASE_URL}/chat-socket")

    }
}