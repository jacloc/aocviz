package com.github.jacloc.android.aocviz.viewmodel.features.solution07

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.solution07.Solution07Input

class Solution07 : Solution() {

    @VisibleForTesting
    var part1Input = Solution07Input.part1

    override fun solvePart1(): String {
        val tachyonManifold = TachyonManifold.parse(part1Input)

        return tachyonManifold.countSplits().toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}