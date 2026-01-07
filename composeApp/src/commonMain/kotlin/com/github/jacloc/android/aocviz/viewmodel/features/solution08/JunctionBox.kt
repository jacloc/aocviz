package com.github.jacloc.android.aocviz.viewmodel.features.solution08

class JunctionBox(val position: Position3D) {

    override fun equals(other: Any?): Boolean {
        return other is JunctionBox && position == other.position
    }

    override fun hashCode(): Int {
        return position.hashCode()
    }

    override fun toString(): String {
        return position.toString()
    }

    private val _connections = mutableSetOf<JunctionBox>(this)
    val connections: Set<JunctionBox> = _connections

    fun distanceTo(other: JunctionBox) = position.distanceTo(other.position)

    fun connect(junctionBox: JunctionBox) {
        if (junctionBox == this || junctionBox in connections) {
            return
        }

        _connections.add(junctionBox)
        connectAll(junctionBox.connections)
        junctionBox.connect(this)
        junctionBox.connectAll(_connections)

        _connections.forEach { it.connect(junctionBox) }
    }

    private fun connectAll(junctionBoxes: Collection<JunctionBox>) {
        _connections.addAll(junctionBoxes)
    }
}
