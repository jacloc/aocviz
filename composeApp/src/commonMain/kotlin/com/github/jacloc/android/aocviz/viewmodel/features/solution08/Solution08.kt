package com.github.jacloc.android.aocviz.viewmodel.features.solution08

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution

class Solution08 : Solution() {
    @VisibleForTesting
    var part1Input = Solution08Input.part1

    @VisibleForTesting
    var part1Iterations = 1000


    override fun solvePart1(): String {
        val junctionBoxes = JunctionBoxes.parse(part1Input)
        val connector = JunctionBoxConnector(junctionBoxes)
        connector.connectJunctionBoxes(part1Iterations)

        val threeLargestCircuitsMultiplied = junctionBoxes
            .map { it.connections }
            .toSet()
            .map { it.size }
            .sortedDescending()
            .take(3)
            .fold(1L) { acc, value ->
                acc * value
            }

        return threeLargestCircuitsMultiplied.toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}