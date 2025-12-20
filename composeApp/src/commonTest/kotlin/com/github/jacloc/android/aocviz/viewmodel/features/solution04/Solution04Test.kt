package com.github.jacloc.android.aocviz.viewmodel.features.solution04

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution04Test {

    @Test
    fun testSolvePart1Example() {
        val solution04 = Solution04().apply {
            part1Input = """
                ..@@.@@@@.
                @@@.@.@.@@
                @@@@@.@.@@
                @.@@@@..@.
                @@.@@@@.@@
                .@@@@@@@.@
                .@.@.@.@@@
                @.@@@.@@@@
                .@@@@@@@@.
                @.@.@@@.@.
            """.trimIndent()
        }
        val result = solution04.solvePart1()
        assertEquals("13", result)
    }

    @Test
    fun testSolvePart1Actual() {
        val solution04 = Solution04()
        val result = solution04.solvePart1()
        assertEquals("???", result)
    }
}