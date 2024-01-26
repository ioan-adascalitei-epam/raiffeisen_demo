package com.raiffeisen.app.presentation.users

import com.raiffeisen.app.domain.model.ErrorInfo

data class UserScreenState(
    val uiState: UiState = UiState.Empty,
    val title: String = ""
)

sealed class UiState {
    data class Success(val userState: List<UserState>) : UiState()
    data class Error(val error: ErrorInfo?) : UiState()
    data object Loading : UiState()
    data object Empty : UiState()

}

data class UserState(
    val hasAttachment: Boolean = true,
    val username: String = "username",
    val userInfo: String = "30 ani din Uk",
    val sentTime: String = "18:51",
    val pictureUrl: String = "",
    val isStar: Boolean = false
)

