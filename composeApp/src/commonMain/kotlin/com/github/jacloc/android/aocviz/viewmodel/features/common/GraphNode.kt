package com.github.jacloc.android.aocviz.viewmodel.features.common

import com.github.jacloc.android.aocviz.viewmodel.features.solution04.PrintingDepartmentTile

open class GraphNode(
    val position: Position,
    val char: Char
) {
    private val _neighbors = mutableListOf<GraphNode>()
    val neighbors: List<GraphNode> = _neighbors


    fun addNeighbor(node: GraphNode) {
        _neighbors.add(node)
    }

    fun addAllNeighbors(nodes: List<GraphNode>) {
        _neighbors.addAll(nodes)
    }
}