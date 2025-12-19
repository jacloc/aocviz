package com.github.jacloc.android.aocviz.viewmodel.features

abstract class SolutionUiState {
}

object LoadingSolutionUiState : SolutionUiState()

data class SimpleSolutionUiState(
    val solution: String,
) : SolutionUiState()