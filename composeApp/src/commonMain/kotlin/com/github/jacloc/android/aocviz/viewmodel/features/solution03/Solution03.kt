package com.github.jacloc.android.aocviz.viewmodel.features.solution03

import androidx.annotation.VisibleForTesting
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.inputs.Solution03Input

class Solution03 : Solution() {
    @VisibleForTesting
    var part1Input = Solution03Input.part1

    override fun solvePart1(): String {
        val batteryBanks = parseBatteryBanks(part1Input)
        val joltageEvaluator = JoltageEvaluator()

        return joltageEvaluator.findMaxJolts(batteryBanks).toString()
    }

    override fun solvePart2(): String {
        return "???"
    }
}

fun parseBatteryBanks(input: String) =
    input.split("\n").map { bankLine ->
        BatteryBank(bankLine.toCharArray().map { it.digitToInt() })
    }