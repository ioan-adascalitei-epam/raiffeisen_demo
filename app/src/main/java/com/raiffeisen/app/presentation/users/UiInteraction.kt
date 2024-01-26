package com.raiffeisen.app.presentation.users

sealed interface UiInteraction {
    data object OnStarClicked : UiInteraction
    data object OnHamburgerClicked : UiInteraction
    data object OnSearchClicked : UiInteraction
    data object OnAddUserClicked : UiInteraction
    data object LoadUsers : UiInteraction
}