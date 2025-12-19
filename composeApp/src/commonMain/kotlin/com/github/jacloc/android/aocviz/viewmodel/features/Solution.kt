package com.github.jacloc.android.aocviz.viewmodel.features

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class Solution {
    abstract fun solvePart1(): String

    abstract fun solvePart2(): String

    protected open val part1SimulationFlow: Flow<SolutionUiState> =
        flow { emit(solvePart1().asSimpleState()) }
    private val part1StateFlow: MutableStateFlow<SolutionUiState> =
        MutableStateFlow(LoadingSolutionUiState)
    private var part1Job: Job? = null

    protected open val part2SimulationFlow: Flow<SolutionUiState> =
        flow { emit(solvePart2().asSimpleState()) }
    private val part2StateFlow: MutableStateFlow<SolutionUiState> =
        MutableStateFlow(LoadingSolutionUiState)
    private var part2Job: Job? = null

    protected open val initialPart1State = LoadingSolutionUiState
    protected open val initialPart2State = LoadingSolutionUiState

    fun initializePart1Simulation(viewModelScope: CoroutineScope) {
        part1Job?.cancel()
        part2Job?.cancel()
        part1Job = viewModelScope.launch {
            part1SimulationFlow.collectLatest {
                part1StateFlow.value = it
            }
        }
    }

    fun initializePart2Simulation(viewModelScope: CoroutineScope) {
        part1Job?.cancel()
        part2Job?.cancel()
        part2Job = viewModelScope.launch {
            part2SimulationFlow.collectLatest {
                part2StateFlow.value = it
            }
        }
    }

    @Composable
    fun ContentPart1() {
        val part1UiState by part1StateFlow
            .collectAsStateWithLifecycle(initialValue = initialPart1State)

        Content(solutionUiState = part1UiState, isPart1 = true)
    }

    @Composable
    private fun Content(
        solutionUiState: SolutionUiState,
        isPart1: Boolean
    ) {
        if (solutionUiState is LoadingSolutionUiState) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
        } else if (solutionUiState is SimpleSolutionUiState) {
            SimpleContent(solutionUiState)
        } else if (isPart1) {
            CustomContentPart1(solutionUiState)
        } else {
            CustomContentPart2(solutionUiState)
        }
    }

    @Composable
    protected open fun CustomContentPart1(uiState: SolutionUiState) {

    }
    
    @Composable
    fun ContentPart2() {
        val part2UiState by part2StateFlow
            .collectAsStateWithLifecycle(initialValue = initialPart2State)

        Content(solutionUiState = part2UiState, isPart1 = false)
    }

    @Composable
    protected open fun CustomContentPart2(uiState: SolutionUiState) {

    }
    
    @Composable
    private fun SimpleContent(solutionUiState: SimpleSolutionUiState) {
        Text(text = "Solution: ${solutionUiState.solution}")
    }

    protected fun String.asSimpleState() =
        SimpleSolutionUiState(this)
}