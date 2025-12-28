package com.github.jacloc.android.aocviz.viewmodel.features.solution04

import com.github.jacloc.android.aocviz.viewmodel.features.common.GraphMap
import com.github.jacloc.android.aocviz.viewmodel.features.common.Position

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
            val tileMap = GraphMap.create(
                input = input,
                nodeCreator = { pos, char ->
                    PrintingDepartmentTile(
                        position = pos,
                        char = char,
                    )
                }
            )

            return PrintingDepartment(tileMap)
        }
    }
}