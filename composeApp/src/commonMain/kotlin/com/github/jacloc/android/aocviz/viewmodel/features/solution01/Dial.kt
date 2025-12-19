package com.github.jacloc.android.aocviz.viewmodel.features.solution01

class Dial() {
    var position = 50
        private set
    var timesHitZero = 0
        private set

    fun executeTurnCommand(turnCommand: TurnCommand) {
        val normalizedAmount = turnCommand.amount % 100
        if (turnCommand.direction == TurnDirection.LEFT) {
            position -= normalizedAmount
        } else {
            position += normalizedAmount
        }

        if (position < 0) {
            position += 100
        } else if (position >= 100) {
            position -= 100
        }

        if (position == 0) {
            timesHitZero++
        }
    }
}