package com.github.jacloc.android.aocviz.viewmodel.features.solution06

class MathProblemSolver {

    fun solveProblem(problem: MathProblem): Long =
        problem.numbers.fold(
            initial = when (problem.type) {
                MathProblemType.ADD -> 0
                MathProblemType.MULT -> 1
            }
        ) { acc, value ->
            when (problem.type) {
                MathProblemType.ADD -> acc + value
                MathProblemType.MULT -> acc * value
            }
        }

    fun solveProblems(problems: List<MathProblem>): Long =
        problems.sumOf(this::solveProblem)
}