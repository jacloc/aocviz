package com.github.jacloc.android.aocviz.viewmodel.features.solution08

object JunctionBoxes {
    fun parse(input: String): List<JunctionBox> {
        val lines = input.split("\n")
        return lines.map { line ->
            val positionList = line.split(",").map {
                it.toLong()
            }
            JunctionBox(
                position = Position3D(
                    x = positionList[0],
                    y = positionList[1],
                    z = positionList[2]
                )
            )
        }
    }
}