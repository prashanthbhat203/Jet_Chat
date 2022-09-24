package com.example.jetchat.data.remote

import com.example.jetchat.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.102.204:8080"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages: Endpoints("${BASE_URL}/messages")

    }

}