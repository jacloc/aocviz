package com.github.jacloc.android.aocviz.viewmodel.features.solution01

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution01Test {

    @Test
    fun testSolvePart1Example() {
        val solution01 = Solution01()
        solution01.part1Input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent()
        val result = solution01.solvePart1()

        assertEquals(3, result.toInt())
    }

    @Test
    fun testSolvePart1Actual() {
        val solution01 = Solution01()
        val result = solution01.solvePart1()
        assertEquals(1102, result.toInt())
    }

    @Test
    fun testSolvePart2Example() {
        val solution01 = Solution01()
        solution01.part2Input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent()

        val result = solution01.solvePart2()

        assertEquals("6", result)
    }

    @Test
    fun testSolvePart2Actual() {
        val solution01 = Solution01()
        val result = solution01.solvePart2()
        assertEquals("?", result)
    }
}