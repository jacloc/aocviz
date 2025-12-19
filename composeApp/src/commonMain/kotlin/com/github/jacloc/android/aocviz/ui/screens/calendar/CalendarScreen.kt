package com.github.jacloc.android.aocviz.ui.screens.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.github.jacloc.android.aocviz.viewmodel.CalendarViewModel
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.VerticalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import kotlinx.datetime.Month
import kotlinx.datetime.YearMonth
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CalendarScreen(
    calendarViewModel: CalendarViewModel,
    onDayClicked: (Int) -> Unit
) {
    CalendarScreen(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        onDayClicked = onDayClicked
    )
}

@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
    onDayClicked: (Int) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Advent of Code 2025 \uD83D\uDE80",
            style = MaterialTheme.typography.headlineLarge,
        )
        VerticalCalendar(
            state = rememberCalendarState(
                startMonth = YearMonth(year = 2025, month = Month.DECEMBER)
            ),
            dayContent = {
                CalendarDayBox(
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(1.dp),
                    calendarDay = it,
                    onDayClicked = onDayClicked
                )
            }
        )
    }
}

@Composable
fun CalendarDayBox(
    modifier: Modifier = Modifier,
    calendarDay: CalendarDay,
    onDayClicked: (Int) -> Unit
) {
    Card(
        onClick = { onDayClicked(calendarDay.date.day) },
        modifier = modifier,
        enabled = calendarDay.position == DayPosition.MonthDate
    ) {
        Text(
            modifier = Modifier.padding(start = 4.dp, top = 2.dp),
            text = calendarDay.date.day.toString()
        )
    }
}

@Composable
@Preview
fun PreviewCalendarScreen() {
    MaterialTheme {
        Surface {
            CalendarScreen(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                onDayClicked = {}
            )
        }
    }
}

