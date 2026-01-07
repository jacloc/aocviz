package com.github.jacloc.android.aocviz.viewmodel.features.solution08

import kotlin.math.abs
import kotlin.math.sqrt

data class Position3D(val x: Long, val y: Long, val z: Long) {
    fun distanceTo(other: Position3D) =
        sqrt(
            ((x - other.x).times(x - other.x) +
                    (y - other.y).times(y - other.y) +
                    (z - other.z).times(z - other.z)).toFloat()
        )
}
