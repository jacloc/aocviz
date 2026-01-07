package com.github.jacloc.android.aocviz.viewmodel.features.solution08

typealias Indices = Pair<Int, Int>

class JunctionBoxConnector(
    private val junctionBoxes: List<JunctionBox>,
) {
    private val distanceToIndices = mutableMapOf<Float, MutableList<Indices>>()
    private val indicesToDistance = mutableMapOf<Indices, Float>()

    init {
        storeDistances(junctionBoxes)
    }

    fun connectJunctionBoxes(amount: Int) {
        val ascendingDistances = distanceToIndices.keys.sorted()
        val ascendingJunctionBoxPairs = ascendingDistances.flatMap { distance ->
            val indicesList = distanceToIndices[distance]
            indicesList?.map { indices ->
                Pair(junctionBoxes[indices.first], junctionBoxes[indices.second])
            } ?: emptyList()
        }.take(amount)

        ascendingJunctionBoxPairs.forEach { pair ->
            pair.first.connect(pair.second)
        }
    }

    private fun storeDistances(junctionBoxes: List<JunctionBox>) {
        for (first in junctionBoxes.indices) {
            for (second in first + 1 .. junctionBoxes.lastIndex) {
                val sameOrder = Pair(first, second)
                val reverseOrder = Pair(second, first)
                if (sameOrder in indicesToDistance || reverseOrder in indicesToDistance) {
                    continue
                }

                val distance = junctionBoxes[first].distanceTo(junctionBoxes[second])
                indicesToDistance[sameOrder] = distance
                indicesToDistance[reverseOrder] = distance
                distanceToIndices.getOrPut(distance) { mutableListOf() }.add(sameOrder)
            }
        }
    }
}