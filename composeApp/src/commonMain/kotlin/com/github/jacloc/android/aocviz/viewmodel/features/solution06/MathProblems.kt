package com.github.jacloc.android.aocviz.viewmodel.features.solution06

object MathProblems {
    fun parse(input: String): List<MathProblem> {
        val lines = input.split("\n")
        val operators = lines.last().splitWhitespace()

        val problemMap = mutableMapOf<Int, MathProblem>()
        for (row in 0 until lines.lastIndex) {
            val lineWithoutWhitespace = lines[row].splitWhitespace()
            for (col in lineWithoutWhitespace.indices) {
                problemMap.getOrPut(col) {
                    MathProblem(
                        type = parseMathProblemType(operators[col]),
                        numbers = mutableListOf()
                    )
                }.numbers.add(lineWithoutWhitespace[col].toLong())
            }
        }

        return problemMap.values.toList()
    }

    private fun String.splitWhitespace(): List<String> =
        split(" ").filter { it.isNotBlank() }

    private fun parseMathProblemType(type: String): MathProblemType =
        when(type) {
            "+" -> MathProblemType.ADD
            "*" -> MathProblemType.MULT
            else -> throw IllegalArgumentException("Unexpected type $type")
        }
}