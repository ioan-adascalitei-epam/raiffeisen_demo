package com.raiffeisen.app.presentation.users.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.raiffeisen.app.presentation.users.UiInteraction
import com.raiffeisen.app.presentation.users.UiState
import com.raiffeisen.app.presentation.users.UserScreenState

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    state: UserScreenState,
    uiInteraction: (UiInteraction) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HeaderItem(modifier = modifier,
                title = state.title,
                onSearchClick = { uiInteraction(UiInteraction.OnSearchClicked) },
                onHamburgerMenuClick = { uiInteraction(UiInteraction.OnHamburgerClicked) })
        },
        floatingActionButton = {
            AddUserItem(
                modifier = modifier,
                onClick = { uiInteraction(UiInteraction.OnAddUserClicked) })
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { innerPadding ->
            when (state.uiState) {
                is UiState.Success -> {
                    val currentState = state.uiState.userState
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        itemsIndexed(
                            currentState,
                            key = { _, item -> item.username }) { index, user ->
                            UserItem(modifier = modifier,
                                userState = user,
                                onStarClicked = { uiInteraction(UiInteraction.OnStarClicked) })
                            if (index == currentState.size - 3) {
                                uiInteraction(UiInteraction.LoadUsers)
                            }
                        }
                    }
                }

                is UiState.Error -> {
                    //Errors to be handled
                }

                UiState.Loading -> {
                    //display loading info
                }

                UiState.Empty -> {
                    //Used for start until data is loaded
                }
            }
        }
    )
}