package com.github.jacloc.android.aocviz.viewmodel.features.solution04

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PrintingDepartmentTest {

    @Test
    fun testParse() {
        val printingDepartment = PrintingDepartment.parse(
            input = """
                ..@@.@@@@.
                @@@.@.@.@@
                @@@@@.@.@@
                @.@@@@..@.
                @@.@@@@.@@
                .@@@@@@@.@
                .@.@.@.@@@
                @.@@@.@@@@
                .@@@@@@@@.
                @.@.@@@.@.
            """.trimIndent()
        )

        with(printingDepartment) {
            val tile00 = getTile(0, 0)
            assertTrue(tile00.isForkliftAccessible)
        }
    }
}