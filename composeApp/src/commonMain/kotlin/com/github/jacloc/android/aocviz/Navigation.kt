package com.github.jacloc.android.aocviz

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.github.jacloc.android.aocviz.ui.screens.calendar.CalendarScreen
import com.github.jacloc.android.aocviz.ui.screens.days.DayScreen
import com.github.jacloc.android.aocviz.viewmodel.CalendarViewModel
import com.github.jacloc.android.aocviz.viewmodel.SolutionViewModel
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
object CalendarRoute

@Serializable
data class DayRoute(val number: Int)

@Composable
fun NavigationComponent(
    navController: NavHostController = rememberNavController(),
    innerPadding: PaddingValues
) {
    val graph =
        navController.createGraph(startDestination = CalendarRoute) {
            composable<CalendarRoute> {
                val calendarViewModel = koinViewModel<CalendarViewModel>()
                CalendarScreen(
                    calendarViewModel = calendarViewModel,
                    onDayClicked = {
                        navController.navigate(DayRoute(number = it))
                    }
                )
            }
            composable<DayRoute> {
                val solutionViewModel = koinViewModel<SolutionViewModel>(
                    parameters = { parametersOf(it.savedStateHandle) }
                )
                DayScreen(solutionViewModel = solutionViewModel)
            }
        }
    NavHost(
        navController = navController,
        graph = graph,
        modifier = Modifier.padding(innerPadding)
    )
}