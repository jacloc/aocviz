package com.github.jacloc.android.aocviz.viewmodel.features.solution08

import kotlin.test.Test
import kotlin.test.assertEquals

class Solution08Test {
    @Test
    fun testSolvePart1Example() {
        val solution08 = Solution08().apply {
            part1Iterations = 10
            part1Input = """
                162,817,812
                57,618,57
                906,360,560
                592,479,940
                352,342,300
                466,668,158
                542,29,236
                431,825,988
                739,650,466
                52,470,668
                216,146,977
                819,987,18
                117,168,530
                805,96,715
                346,949,466
                970,615,88
                941,993,340
                862,61,35
                984,92,344
                425,690,689
            """.trimIndent()
        }
        val result = solution08.solvePart1()
        assertEquals("40", result)
    }

    @Test
    fun testSolvePart1Actual() {
        val solution08 = Solution08()
        val result = solution08.solvePart1()
        assertEquals("26400", result)
    }
}