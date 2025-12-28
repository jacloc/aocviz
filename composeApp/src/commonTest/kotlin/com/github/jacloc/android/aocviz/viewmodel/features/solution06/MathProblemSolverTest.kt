package com.github.jacloc.android.aocviz.viewmodel.features.solution06

import kotlin.test.Test
import kotlin.test.assertEquals

class MathProblemSolverTest {

    @Test
    fun testSolveProblems() {
        val solver = MathProblemSolver()
        val solution = solver.solveProblems(
            listOf(
                MathProblem(
                    MathProblemType.ADD,
                    numbers = mutableListOf(
                        1,
                        2,
                        3
                    )
                ),
                MathProblem(
                    MathProblemType.ADD,
                    numbers = mutableListOf(
                        1,
                        2,
                        3
                    )
                ),
                MathProblem(
                    MathProblemType.MULT,
                    numbers = mutableListOf(
                        1,
                        2,
                        3
                    )
                ),
            )
        )
        assertEquals(18, solution)
    }
}