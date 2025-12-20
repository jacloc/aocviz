package com.github.jacloc.android.aocviz.viewmodel.features.solution01

import kotlin.test.Test
import kotlin.test.assertEquals

class DialTest {

    @Test
    fun testTurns() {
        val dial = Dial()
        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 68
            )
        )
        assertEquals(82, dial.position)
        assertEquals(0, dial.timesHitZero)
        assertEquals(1, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 30
            )
        )
        assertEquals(52, dial.position)
        assertEquals(0, dial.timesHitZero)
        assertEquals(1, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.RIGHT,
                amount = 48
            )
        )
        assertEquals(0, dial.position)
        assertEquals(1, dial.timesHitZero)
        assertEquals(2, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 5
            )
        )
        assertEquals(95, dial.position)
        assertEquals(1, dial.timesHitZero)
        assertEquals(2, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.RIGHT,
                amount = 60
            )
        )
        assertEquals(55, dial.position)
        assertEquals(1, dial.timesHitZero)
        assertEquals(3, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 55
            )
        )
        assertEquals(0, dial.position)
        assertEquals(2, dial.timesHitZero)
        assertEquals(3, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 1
            )
        )
        assertEquals(99, dial.position)
        assertEquals(2, dial.timesHitZero)
        assertEquals(3, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 99
            )
        )
        assertEquals(0, dial.position)
        assertEquals(3, dial.timesHitZero)
        assertEquals(3, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.RIGHT,
                amount = 14
            )
        )
        assertEquals(14, dial.position)
        assertEquals(3, dial.timesHitZero)
        assertEquals(3, dial.timesPassedZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 82
            )
        )
        assertEquals(32, dial.position)
        assertEquals(3, dial.timesHitZero)
        assertEquals(4, dial.timesPassedZero)
    }
}