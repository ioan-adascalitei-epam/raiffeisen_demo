package com.raiffeisen.app.presentation.users

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raiffeisen.app.domain.usecase.GetUserListUseCase
import com.raiffeisen.app.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
): ViewModel() {

    fun getUsers() {
        viewModelScope.launch {
           when(getUserListUseCase.getUserList()) {
               is Result.Success -> {
                    //TODO update ui state
                }
                is Result.Error -> {
                    //TODO update ui state
                }
            }
        }
    }
}