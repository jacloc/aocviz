package com.github.jacloc.android.aocviz.viewmodel.features.solution06

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution06Test {

    @Test
    fun testSolvePart1Example() {
        val solution06 = Solution06().apply {
            part1Input = """
                123 328  51 64 
                 45 64  387 23 
                  6 98  215 314
                *   +   *   +  
            """.trimIndent()
        }
        val result = solution06.solvePart1()
        assertEquals("4277556", result)
    }

    @Test
    fun testSolvePart1Actual() {
        val solution06 = Solution06()
        val result = solution06.solvePart1()
        assertEquals("6371789547734", result)
    }
}