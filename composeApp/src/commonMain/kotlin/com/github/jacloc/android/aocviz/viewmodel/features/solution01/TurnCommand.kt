package com.github.jacloc.android.aocviz.viewmodel.features.solution01

data class TurnCommand(val direction: TurnDirection, val amount: Int)

fun String.parseTurnCommand(): TurnCommand {
    return TurnCommand(
        direction = if (get(0) == 'L') TurnDirection.LEFT else TurnDirection.RIGHT,
        amount = removeRange(0, 1).toInt()
    )
}