package com.github.lasnelus.Capybara.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Destination : NavKey {
    @Serializable
    data object Home : Destination

    @Serializable
    data class Detail(val date: String): Destination
}