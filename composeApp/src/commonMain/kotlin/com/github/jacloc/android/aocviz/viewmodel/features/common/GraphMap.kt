package com.github.jacloc.android.aocviz.viewmodel.features.common

object GraphMap {
    fun all(): (GraphNode) -> List<Position> = { node ->
        with(node.position) {
            listOf(
                topLeft(),
                topMiddle(),
                topRight(),
                middleLeft(),
                middleRight(),
                bottomLeft(),
                bottomMiddle(),
                bottomRight()
            )
        }
    }

    fun createSimple(
        input: String,
        neighboringPositions: (GraphNode) -> List<Position> = all()
    ): Map<Position, GraphNode> {
        return create(
            input = input,
            nodeCreator = { pos, char ->
                GraphNode(pos, char)
            },
            neighboringPositions = neighboringPositions
        )
    }

    fun <T : GraphNode> create(
        input: String,
        nodeCreator: (Position, Char) -> T,
        neighboringPositions: (T) -> List<Position> = all(),
    ): Map<Position, T> {
        val rows = input.split("\n")
        val nodeMap = mutableMapOf<Position, T>()
        var bottomRight = Position(0, 0)
        for (rowIndex in rows.indices) {
            val row = rows[rowIndex].toCharArray()
            for (colIndex in row.indices) {
                val position = Position(
                    x = colIndex,
                    y = rowIndex
                )
                bottomRight = position
                nodeMap[position] = nodeCreator(position, row[colIndex])
            }
        }

        connectNodes(nodeMap, bottomRight, neighboringPositions)

        return nodeMap
    }


    private fun <T : GraphNode> connectNodes(
        nodeMap: Map<Position, T>,
        bottomRight: Position,
        neighboringPositions: (T) -> List<Position>
    ) {
        nodeMap.values.forEach { node ->
            node.addAllNeighbors(getNeighbors(nodeMap, node, bottomRight, neighboringPositions))
        }
    }

    private fun <T : GraphNode> getNeighbors(
        nodeMap: Map<Position, T>,
        node: T,
        bottomRight: Position,
        neighboringPositions: (T) -> List<Position>
    ): List<T> = node.getNeighboringPositions(bottomRight, neighboringPositions)
        .map { nodeMap[it]!! }

    private fun <T : GraphNode> T.getNeighboringPositions(
        bottomRight: Position,
        neighboringPositions: (T) -> List<Position>
    ): List<Position> = neighboringPositions(this).filter {
        if (it.x < 0 || it.x > bottomRight.x) {
            false
        } else if (it.y < 0 || it.y > bottomRight.y) {
            false
        } else {
            true
        }
    }
}
