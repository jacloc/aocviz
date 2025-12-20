package com.github.jacloc.android.aocviz.viewmodel.features.solution05

object FreshIdRanges {
    fun parseAsIs(input: String) = parseFreshIdRanges(input)

    fun parseIntoMergedRanges(input: String) = parseAsIs(input).merge()

    private fun parseFreshIdRanges(input: String) = input.split("\n")
        .filter { line -> line.contains("-") }
        .map { line ->
            val splitLine = line.split("-")
            LongRange(start = splitLine.first().toLong(), endInclusive = splitLine.last().toLong())
        }

    private fun List<LongRange>.merge(): List<LongRange> {
        val sortedRanges = sortedBy { it.first }

        val mergedRanges = mutableListOf(sortedRanges.first())
        for (i in 1 .. sortedRanges.lastIndex) {
            val range = sortedRanges[i]
            val lastMergedRange = mergedRanges.last()
            if (range.first in lastMergedRange) {
                mergedRanges[mergedRanges.lastIndex] = LongRange(
                    start = lastMergedRange.first,
                    endInclusive = if (lastMergedRange.last > range.last) {
                        lastMergedRange.last
                    } else {
                        range.last
                    }
                )
            } else {
                mergedRanges.add(range)
            }
        }

        return mergedRanges
    }
}