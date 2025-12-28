package com.github.jacloc.android.aocviz.viewmodel.features.solution06

import kotlin.test.Test
import kotlin.test.assertEquals

class MathProblemsTest {

    @Test
    fun testParse() {
        val input = """
                123 328  51 64 
                 45 64  387 23 
                  6 98  215 314
                *   +   *   +  
            """.trimIndent()

        val problems = MathProblems.parse(input)
        assertEquals(
            expected = listOf(
                MathProblem(
                    type = MathProblemType.MULT,
                    numbers = mutableListOf(123L, 45L, 6L)
                ),
                MathProblem(
                    type = MathProblemType.ADD,
                    numbers = mutableListOf(328L, 64L, 98L)
                ),
                MathProblem(
                    type = MathProblemType.MULT,
                    numbers = mutableListOf(51L, 387L, 215L)
                ),
                MathProblem(
                    type = MathProblemType.ADD,
                    numbers = mutableListOf(64L, 23L, 314L)
                ),
            ),
            actual = problems
        )
    }
}