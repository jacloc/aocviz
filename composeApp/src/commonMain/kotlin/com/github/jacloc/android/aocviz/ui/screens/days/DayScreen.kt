package com.github.jacloc.android.aocviz.ui.screens.days

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.jacloc.android.aocviz.viewmodel.SolutionViewModel
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.solution01.Solution01
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DayScreen(solutionViewModel: SolutionViewModel) {
    DayScreen(
        modifier = Modifier.fillMaxSize(),
        solution = solutionViewModel.solution,
        onPageChanged = {
            solutionViewModel.updateTabIndex(it)
        }
    )
}

@Composable
fun DayScreen(
    modifier: Modifier = Modifier,
    solution: Solution,
    onPageChanged: (Int) -> Unit
) {
    val pagerState = rememberPagerState { 2 }
    LaunchedEffect(pagerState.currentPage) {
        onPageChanged(pagerState.currentPage)
    }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = pagerState.currentPage == 0,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                },
                text = { Text("Part 1") }
            )
            Tab(
                selected = pagerState.currentPage == 1,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                },
                text = { Text("Part 2") }
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                if (page == 0) {
                    solution.ContentPart1()
                } else {
                    solution.ContentPart2()
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewDayScreen() {
    MaterialTheme {
        Surface {
            DayScreen(
                modifier = Modifier.fillMaxSize(),
                solution = Solution01(),
                onPageChanged = {}
            )
        }
    }
}