package com.example.jetchat.presentation.chat

import com.example.jetchat.data.remote.MessageService
import com.example.jetchat.domain.model.Message

data class ChatState(
    val message: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
