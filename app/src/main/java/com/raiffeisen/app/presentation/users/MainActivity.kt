package com.raiffeisen.app.presentation.users

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raiffeisen.app.presentation.ui.theme.RaiffeisenDemoTheme
import com.raiffeisen.app.presentation.users.components.UserScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaiffeisenDemoTheme {
                val state by viewModel.uiState.collectAsStateWithLifecycle()
                UserScreen(
                    modifier = Modifier,
                    state = state,
                    uiInteraction = viewModel::handleUiInteraction
                )
            }
        }
    }
}