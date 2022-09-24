package com.example.jetchat.presentation.username


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsernameVIewModel @Inject constructor() : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _onLoinChat = MutableSharedFlow<String>()
    val onJoinChat = _onLoinChat.asSharedFlow()

    fun onUsernameChange(username: String) {
        _usernameText.value = username
    }

    fun onJoinClick() {
        viewModelScope.launch {
            if (usernameText.value.isNotBlank()) {
                _onLoinChat.emit(usernameText.value)
            }

        }
    }

}