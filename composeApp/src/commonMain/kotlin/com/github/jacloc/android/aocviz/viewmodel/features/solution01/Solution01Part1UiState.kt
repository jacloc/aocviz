package com.github.jacloc.android.aocviz.viewmodel.features.solution01

import com.github.jacloc.android.aocviz.viewmodel.features.SolutionUiState

data class Solution01Part1UiState(
    val dialPosition: Int,
    val password: Int,
    val progress: Float
) : SolutionUiState()
