package com.github.lasnelus.Capybara.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.github.lasnelus.Capybara.ui.feature.detail.DetailScreen
import com.github.lasnelus.Capybara.ui.feature.home.HomeScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavHost() {
    val backStack = rememberNavBackStack(Destination.Home)
    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Destination.Home> {
                HomeScreen(
                    onDetailClick = { date -> backStack.add(Destination.Detail(date = date)) }
                )
            }
            entry<Destination.Detail> { destination ->
                DetailScreen(
                    onBackClick = {backStack.removeLastOrNull()},
                    date = destination.date
                )
            }
        }
    )
}