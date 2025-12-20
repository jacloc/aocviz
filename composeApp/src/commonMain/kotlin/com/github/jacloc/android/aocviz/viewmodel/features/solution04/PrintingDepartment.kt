package com.github.jacloc.android.aocviz.viewmodel.features.solution04

class PrintingDepartment(
    private val tiles: Map<Position, PrintingDepartmentTile>
) {

    val numberOfForkliftAccessiblePaperTiles
        get() = tiles.values.count {
            it.rollsOfPaper >= 1 && it.isForkliftAccessible
        }

    fun getTile(x: Int, y: Int): PrintingDepartmentTile {
        return tiles[Position(x, y)]!!
    }

    companion object {
        fun parse(input: String): PrintingDepartment {
            val rows = input.split("\n")
            val tileMap = mutableMapOf<Position, PrintingDepartmentTile>()
            var bottomRight: Position = Position(0, 0)
            for (rowIndex in rows.indices) {
                val row = rows[rowIndex].toCharArray()
                for (colIndex in row.indices) {
                    val position = Position(
                        x = colIndex,
                        y = rowIndex
                    )
                    bottomRight = position
                    val tile = PrintingDepartmentTile(
                        position = position,
                        rollsOfPaper = if (row[colIndex] == '@') {
                            1
                        } else {
                            0
                        }
                    )
                    tileMap[position] = tile
                }
            }

            connectTiles(tileMap, bottomRight)

            return PrintingDepartment(tileMap)
        }

        private fun connectTiles(
            tileMap: Map<Position, PrintingDepartmentTile>,
            bottomRight: Position
        ) {
            tileMap.values.forEach { tile ->
                tile.addAllNeighbors(getNeighbors(tileMap, tile.position, bottomRight))
            }
        }

        private fun getNeighbors(
            tileMap: Map<Position, PrintingDepartmentTile>,
            position: Position,
            bottomRight: Position
        ): List<PrintingDepartmentTile> =
            position.getNeighboringPositions(bottomRight).map { tileMap[it]!! }

        private fun Position.getNeighboringPositions(bottomRight: Position): List<Position> =
            listOfNotNull(
                // Top Left
                createPosition(x - 1, y - 1, bottomRight),
                // Top Middle
                createPosition(x, y - 1, bottomRight),
                // Top Right
                createPosition(x + 1, y - 1, bottomRight),
                // Mid Left
                createPosition(x - 1, y, bottomRight),
                // Mid Right
                createPosition(x + 1, y, bottomRight),
                // Bottom Left
                createPosition(x - 1, y + 1, bottomRight),
                // Bottom Mid
                createPosition(x, y + 1, bottomRight),
                // Bottom Right
                createPosition(x + 1, y + 1, bottomRight)
            )

        private fun createPosition(
            x: Int,
            y: Int,
            bottomRight: Position
        ): Position? {
            if (x < 0 || x > bottomRight.x) {
                return null
            }
            if (y < 0 || y > bottomRight.y) {
                return null
            }
            return Position(x, y)
        }
    }
}