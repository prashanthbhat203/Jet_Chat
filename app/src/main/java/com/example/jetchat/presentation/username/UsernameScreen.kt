package com.example.jetchat.presentation.username

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameScreen(
    viewModel: UsernameVIewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {

    LaunchedEffect(key1 = true) {
        viewModel.onJoinChat.collectLatest { username ->
            onNavigate("chat_screen/$username")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            TextField(
                value = viewModel.usernameText.value,
                onValueChange = viewModel::onUsernameChange,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Enter a username...")}
                )
            Spacer(modifier = Modifier.height(8.dp))
            
            Button(onClick = viewModel::onJoinClick) {
                Text(text = "Join")
            }
        }

    }
}