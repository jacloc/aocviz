package com.github.jacloc.android.aocviz.viewmodel.features.solution01

import kotlin.math.floor

class Dial() {
    var position = 50
        private set
    var timesHitZero = 0
        private set

    var timesPassedZero = 0
        private set

    fun executeTurnCommand(turnCommand: TurnCommand) {
        timesPassedZero += floor(turnCommand.amount / 100f).toInt()
        val prevPosition = position

        val normalizedAmount = turnCommand.amount % 100
        if (turnCommand.direction == TurnDirection.LEFT) {
            position -= normalizedAmount
        } else {
            position += normalizedAmount
        }

        if (position < 0) {
            position += 100
            if (prevPosition != 0) {
                timesPassedZero++
            }
        } else if (position >= 100) {
            position -= 100
            if (prevPosition != 0) {
                timesPassedZero++
            }
        }

        if (position == 0) {
            timesHitZero++
        }
    }
}