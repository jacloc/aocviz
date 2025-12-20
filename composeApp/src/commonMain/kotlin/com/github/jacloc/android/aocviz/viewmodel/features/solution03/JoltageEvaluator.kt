package com.github.jacloc.android.aocviz.viewmodel.features.solution03

class JoltageEvaluator {

    fun findMaxJolts(batteryBanks: List<BatteryBank>): Int =
        batteryBanks.sumOf { findMaxJolts(it) }

    fun findMaxJolts(batteryBank: BatteryBank): Int {
        val highestFirstDigitIndex = getHighestJoltIndex(
            batteryBank = batteryBank,
            range = 0 ..<batteryBank.jolts.lastIndex
        )
        val highestSecondDigitIndex = getHighestJoltIndex(
            batteryBank = batteryBank,
            range = highestFirstDigitIndex + 1 .. batteryBank.jolts.lastIndex
        )

        val highestFirstDigit = batteryBank.jolts[highestFirstDigitIndex]
        val highestSecondDigit = batteryBank.jolts[highestSecondDigitIndex]

        return highestFirstDigit * 10 + highestSecondDigit
    }

    private fun getHighestJoltIndex(batteryBank: BatteryBank, range: IntRange): Int {
        var highestIndex = range.start
        for (i in range) {
            val jolt = batteryBank.jolts[i]
            val highestJolt = batteryBank.jolts[highestIndex]
            if (jolt > highestJolt) {
                highestIndex = i
            }
        }
        return highestIndex
    }
}