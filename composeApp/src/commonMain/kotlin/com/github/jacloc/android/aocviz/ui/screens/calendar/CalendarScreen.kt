package com.github.jacloc.android.aocviz.ui.screens.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.jacloc.android.aocviz.viewmodel.CalendarViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CalendarScreen(
    calendarViewModel: CalendarViewModel,
    onDayClicked: (Int) -> Unit
) {
    CalendarScreen(
        modifier = Modifier.fillMaxSize(),
        onDayClicked = onDayClicked
    )
}

@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
    onDayClicked: (Int) -> Unit
) {
    Column {
        Text(text = "Calendar")
        Button(onClick = {
            onDayClicked(1)
        }) {
            Text("Nav to day")
        }
    }
}

@Composable
@Preview
fun PreviewCalendarScreen() {
    MaterialTheme {
        CalendarScreen(
            modifier = Modifier.fillMaxSize(),
            onDayClicked = {}
        )
    }
}

