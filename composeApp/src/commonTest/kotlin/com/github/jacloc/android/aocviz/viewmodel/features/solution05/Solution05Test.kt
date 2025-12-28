package com.github.jacloc.android.aocviz.viewmodel.features.solution05

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution05Test {

    @Test
    fun testSolvePart1Example() {
        val solution05 = Solution05().apply {
            part1Input = """
                3-5
                10-14
                16-20
                12-18

                1
                5
                8
                11
                17
                32
            """.trimIndent()
        }
        val result = solution05.solvePart1()
        assertEquals("3", result)
    }

    @Test
    fun testSolvePart1Actual() {
        val solution05 = Solution05()
        val result = solution05.solvePart1()
        assertEquals("664", result)
    }
}