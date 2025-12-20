package com.github.jacloc.android.aocviz.viewmodel.features.solution02

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution02Test {

    @Test
    fun testSolvePart1Example() {
        val solution02 = Solution02().apply {
            part1Input = """
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
            """.trimIndent()
        }

        val result = solution02.solvePart1()

        assertEquals("1227775554", result)
    }

    @Test
    fun testSolvePart1Actual() {
        val solution02 = Solution02()
        val result = solution02.solvePart1()
        assertEquals("???", result)
    }
}