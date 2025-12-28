package com.github.jacloc.android.aocviz.viewmodel.features.solution03

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution03Test {

    @Test
    fun testSolvePart1Example() {
        val solution03 = Solution03().apply {
            part1Input = """
                987654321111111
                811111111111119
                234234234234278
                818181911112111
            """.trimIndent()
        }
        val result = solution03.solvePart1()
        assertEquals("357", result)
    }

    @Test
    fun testSolvePart1Actual() {
        val solution03 = Solution03()
        val result = solution03.solvePart1()
        assertEquals("17405", result)
    }

    @Test
    fun testSolvePart2Example() {

    }

    @Test
    fun testSolvePart2Actual() {

    }
}