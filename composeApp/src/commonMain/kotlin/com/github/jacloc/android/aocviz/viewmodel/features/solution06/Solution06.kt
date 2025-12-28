package com.github.jacloc.android.aocviz.viewmodel.features.solution06

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.solution06.Solution06Input

class Solution06 : Solution() {
    @VisibleForTesting
    var part1Input = Solution06Input.part1

    override fun solvePart1(): String {
        val problems = MathProblems.parse(part1Input)
        val solver = MathProblemSolver()

        return solver.solveProblems(problems).toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}