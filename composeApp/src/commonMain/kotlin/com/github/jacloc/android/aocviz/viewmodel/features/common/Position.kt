package com.github.jacloc.android.aocviz.viewmodel.features.common

data class Position(val x: Int, val y: Int) {
    fun topLeft() = Position(x - 1, y - 1)
    fun topMiddle() = Position(x, y - 1)
    fun topRight() = Position(x + 1, y - 1)
    fun middleLeft() = Position(x - 1, y)
    fun middleRight() = Position(x + 1, y)
    fun bottomLeft() = Position(x - 1, y + 1)
    fun bottomMiddle() = Position(x, y + 1)
    fun bottomRight() = Position(x + 1, y + 1)
}