package com.github.jacloc.android.aocviz.viewmodel.features.solution04

import com.github.jacloc.android.aocviz.viewmodel.features.common.GraphNode
import com.github.jacloc.android.aocviz.viewmodel.features.common.Position

private const val PAPER_LIMIT = 4

class PrintingDepartmentTile(
    position: Position,
    char: Char,
) : GraphNode(position, char) {

    val rollsOfPaper = if (char == '@') 1 else 0

    val isForkliftAccessible
        get() = (neighbors.sumOf { (it as PrintingDepartmentTile).rollsOfPaper }) < PAPER_LIMIT
}