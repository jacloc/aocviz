package com.github.jacloc.android.aocviz.ui.screens.days

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.jacloc.android.aocviz.viewmodel.DayViewModel

@Composable
fun DayScreen(dayViewModel: DayViewModel) {
    Text(text = "Welcome to day ${dayViewModel.day}")
}