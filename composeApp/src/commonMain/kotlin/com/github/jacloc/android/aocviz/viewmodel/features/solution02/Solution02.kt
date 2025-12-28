package com.github.jacloc.android.aocviz.viewmodel.features.solution02

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.solution02.Solution02Input

class Solution02 : Solution() {
    @VisibleForTesting
    var part1Input = Solution02Input.part1

    @VisibleForTesting
    var part2Input = Solution02Input.part2

    override fun solvePart1(): String {
        val productIdRanges = parseProductIdRanges(part1Input)
        val counter = InvalidProductIdCounter()

        return counter.countAllInvalidProductIds(productIdRanges).toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}

fun parseProductIdRanges(input: String) =
    input.split(",").map {
        val rangeAsStrList = it.split("-")
        ProductIdRange(
            start = rangeAsStrList.first(),
            end = rangeAsStrList.last()
        )
    }