package com.github.jacloc.android.aocviz.viewmodel.features.solution08

import kotlin.test.Test
import kotlin.test.assertEquals

class JunctionBoxTest {

    @Test
    fun testConnect() {
        val junctionBox = JunctionBox(position = Position3D(1, 1, 1))
        val junctionBox2 = JunctionBox(position = Position3D(2, 2, 2))
        val junctionBox3 = JunctionBox(position = Position3D(3, 3, 3))

        junctionBox.connect(junctionBox2)
        assertEquals(setOf(junctionBox, junctionBox2), junctionBox.connections, message = "JB1 should be connected to JB2")
        assertEquals(setOf(junctionBox2, junctionBox), junctionBox2.connections, message = "JB2 should be connected to JB1")
        assertEquals(setOf(junctionBox3), junctionBox3.connections, message = "JB3 connections should be empty")

        junctionBox.connect(junctionBox3)
        assertEquals(setOf(junctionBox, junctionBox2, junctionBox3), junctionBox.connections, message = "JB1 should be connected to JB2, JB3")
        assertEquals(setOf(junctionBox2, junctionBox, junctionBox3), junctionBox2.connections, message = "JB2 should be connected to JB1, JB3")
        assertEquals(setOf(junctionBox3, junctionBox, junctionBox2), junctionBox3.connections, message = "JB3 should be connected to JB1, JB2")

        junctionBox2.connect(junctionBox3)
        assertEquals(setOf(junctionBox, junctionBox2, junctionBox3), junctionBox.connections, message = "JB1 should be connected to JB2, JB3 - nothing should have changed")
        assertEquals(setOf(junctionBox2, junctionBox, junctionBox3), junctionBox2.connections, message = "JB2 should be connected to JB1, JB3 - nothing should have changed")
        assertEquals(setOf(junctionBox3, junctionBox, junctionBox2), junctionBox3.connections, message = "JB3 should be connected to JB1, JB2 - nothing should have changed")
    }
}