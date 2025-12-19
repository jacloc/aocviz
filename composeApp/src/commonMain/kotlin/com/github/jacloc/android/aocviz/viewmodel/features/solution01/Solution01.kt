package com.github.jacloc.android.aocviz.viewmodel.features.solution01

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.jacloc.android.aocviz.ui.components.DialComponent
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.SolutionUiState
import com.github.jacloc.android.aocviz.viewmodel.features.inputs.Solution01Input
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jetbrains.compose.ui.tooling.preview.Preview

class Solution01 : Solution() {
    @VisibleForTesting
    var part1Input = Solution01Input.part1

    override fun solvePart1(): String {
        val turnCommands = parseTurnCommands()

        val dial = Dial()
        turnCommands.forEach {
            dial.executeTurnCommand(it)
        }

        return dial.timesHitZero.toString()
    }

    private fun parseTurnCommands() = part1Input.split("\n").map { line ->
        line.parseTurnCommand()
    }

    override val part1SimulationFlow: Flow<SolutionUiState> = flow {
        val commands = parseTurnCommands()
        val dial = Dial()

        emit(
            Solution01Part1UiState(
                dialPosition = dial.position,
                password = dial.timesHitZero,
                progress = 0f
            )
        )

        delay(100)
        commands.forEachIndexed { index, command ->
            dial.executeTurnCommand(command)
            //println("Executed turn command")
            delay(1000 / 60)
            emit(
                Solution01Part1UiState(
                    dialPosition = dial.position,
                    password = dial.timesHitZero,
                    progress = (index + 1).toFloat() / commands.size.toFloat()
                )
            )
        }
    }

    @Composable
    override fun CustomContentPart1(uiState: SolutionUiState) {
        if (uiState !is Solution01Part1UiState) {
            throw IllegalArgumentException("Unexpected state")
        }

        Column(modifier = Modifier.fillMaxSize()) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                progress = { uiState.progress }
            )
            Text(text = uiState.dialPosition.toString())
            DialComponent(
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                dialPosition = uiState.dialPosition
            )
            Text(
                modifier = Modifier.fillMaxWidth().wrapContentSize(),
                text = "Password: ${uiState.password}"
            )
        }
    }

    override fun solvePart2(): String {
        return "Test2"
    }
}
