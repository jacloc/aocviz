package com.github.jacloc.android.aocviz.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.github.jacloc.android.aocviz.DayRoute
import com.github.jacloc.android.aocviz.viewmodel.features.DayFeature

class DayViewModel(
    savedState: SavedStateHandle,
    private val dayFeatureMap: Map<Int, DayFeature>
) : ViewModel() {

    val day: Int = savedState.toRoute<DayRoute>().number
}