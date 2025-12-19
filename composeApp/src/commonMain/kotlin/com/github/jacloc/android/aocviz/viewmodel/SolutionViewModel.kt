package com.github.jacloc.android.aocviz.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.github.jacloc.android.aocviz.DayRoute
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SolutionViewModel(
    savedState: SavedStateHandle,
    solutionMap: Map<Int, Solution>
) : ViewModel() {

    val day: Int = savedState.toRoute<DayRoute>().number
    val solution = solutionMap[day]!!
    private val tabIndexStateFlow = MutableStateFlow(0)

    init {
        viewModelScope.launch {
            tabIndexStateFlow.collectLatest { index ->
                if (index == 0) {
                    solution.initializePart1Simulation(viewModelScope)
                } else {
                    solution.initializePart2Simulation(viewModelScope)
                }
            }
        }
    }

    fun updateTabIndex(index: Int) {
        tabIndexStateFlow.value = index
    }
}
