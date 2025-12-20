package com.github.jacloc.android.aocviz.viewmodel.features.solution05

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.inputs.Solution05Input

class Solution05 : Solution() {
    @VisibleForTesting
    var part1Input = Solution05Input.part1

    override fun solvePart1(): String {
        val freshIdRanges = FreshIdRanges.parseIntoMergedRanges(part1Input)
        val ingredientIds = parseIngredientIds(part1Input)

        val sumOfFreshIngredients = ingredientIds.count { id ->
            freshIdRanges.containsId(id)
        }
        return sumOfFreshIngredients.toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}

fun List<LongRange>.containsId(id: Long): Boolean {
    for (range in this) {
        if (id in range) {
            return true
        }
    }
    return false
}

fun parseIngredientIds(input: String) = input.split("\n")
    .mapNotNull { line -> line.toLongOrNull() }