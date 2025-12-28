package com.github.jacloc.android.aocviz.viewmodel.features.solution04

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.solution04.Solution04Input

class Solution04 : Solution() {
    @VisibleForTesting
    var part1Input = Solution04Input.part1

    override fun solvePart1(): String {
        val printingDepartment = PrintingDepartment.parse(part1Input)

        return printingDepartment.numberOfForkliftAccessiblePaperTiles.toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}