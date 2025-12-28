package com.github.jacloc.android.aocviz.viewmodel.features.solution07

import com.github.jacloc.android.aocviz.viewmodel.features.common.GraphMap
import com.github.jacloc.android.aocviz.viewmodel.features.common.GraphNode
import com.github.jacloc.android.aocviz.viewmodel.features.common.Position

class TachyonManifold(
    private val nodes: Map<Position, GraphNode>
) {
    private val startNode = nodes.values.first { it.isStart() }

    fun countSplits(): Long {
        val visited = mutableSetOf<GraphNode>()
        val queue = mutableListOf(startNode)
        var splitCount = 0L

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (current !in visited) {
                visited.add(current)
                if (current.isSplitter()) {
                    splitCount++
                }
                queue.addAll(current.neighbors)
            }
        }

        return splitCount
    }

    companion object {
        fun GraphNode.isSplitter() = char == '^'
        fun GraphNode.isStart() = char == 'S'


        fun parse(input: String): TachyonManifold {
            val nodeMap = GraphMap.createSimple(
                input = input,
                neighboringPositions = { node ->
                    with(node.position) {
                        if (node.isSplitter()) {
                            listOf(middleLeft(), middleRight())
                        } else {
                            listOf(bottomMiddle())
                        }
                    }
                }
            )

            return TachyonManifold(nodeMap)
        }
    }
}