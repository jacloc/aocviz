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

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.LEFT,
                amount = 30
            )
        )
        assertEquals(52, dial.position)
        assertEquals(0, dial.timesHitZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.RIGHT,
                amount = 48
            )
        )
        assertEquals(0, dial.position)
        assertEquals(1, dial.timesHitZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.RIGHT,
                amount = 848
            )
        )
        assertEquals(48, dial.position)
        assertEquals(1, dial.timesHitZero)

        dial.executeTurnCommand(
            TurnCommand(
                direction = TurnDirection.RIGHT,
                amount = 1048
            )
        )
        assertEquals(96, dial.position)
        assertEquals(1, dial.timesHitZero)
    }
}