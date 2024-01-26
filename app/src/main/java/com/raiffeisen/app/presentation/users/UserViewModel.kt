package com.raiffeisen.app.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raiffeisen.app.domain.usecase.GetUserListUseCase
import com.raiffeisen.app.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val mapper: UserStateMapper
) : ViewModel() {

    private var _uiState = MutableStateFlow(UserScreenState())
    val uiState: StateFlow<UserScreenState> = _uiState

    private var currentPage = 0
    private val maxPageLoadingCount = 3

    init {
        getUsers()
        _uiState.value = _uiState.value.copy(title = "Users")
    }

    fun handleUiInteraction(event: UiInteraction) {
        when (event) {
            UiInteraction.LoadUsers -> {
                if (currentPage < maxPageLoadingCount) {
                    getUsers()
                }
            }

            UiInteraction.OnAddUserClicked -> {}
            UiInteraction.OnHamburgerClicked -> {}
            UiInteraction.OnSearchClicked -> {}
            UiInteraction.OnStarClicked -> {}
        }
    }

    private fun getUsers() {
        viewModelScope.launch {
            when (val result = getUserListUseCase.getUserList(currentPage)) {
                is Result.Success -> {
                    currentPage++
                    val list = mutableListOf<UserState>()
                    list.addAll ((_uiState.value.uiState as? UiState.Success)?.userState.orEmpty())
                    list.addAll(result.info?.map { mapper.toUserState(it) }.orEmpty())
                    _uiState.value = _uiState.value.copy(uiState = UiState.Success(list))
                }

                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(uiState = UiState.Error(result.errorInfo))
                }
            }
        }
    }
}