package com.github.jacloc.android.aocviz.viewmodel.features.solution04

private const val PAPER_LIMIT = 4

class PrintingDepartmentTile(
    val position: Position,
    val rollsOfPaper: Int,
) {
    private val _neighbors = mutableListOf<PrintingDepartmentTile>()
    val neighbors: List<PrintingDepartmentTile> = _neighbors

    val isForkliftAccessible
        get() = (neighbors.sumOf { it.rollsOfPaper }) < PAPER_LIMIT

    fun addNeighbor(tile: PrintingDepartmentTile) {
        _neighbors.add(tile)
    }

    fun addAllNeighbors(tiles: List<PrintingDepartmentTile>) {
        _neighbors.addAll(tiles)
    }
}