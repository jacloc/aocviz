package com.github.jacloc.android.aocviz.viewmodel.features.solution02

class InvalidProductIdCounter {

    fun countAllInvalidProductIds(productIdRangeList: List<ProductIdRange>): Long =
        productIdRangeList.sumOf { range ->
            getInvalidProductIds(range).sumOf { id -> id  }
        }

    fun getInvalidProductIds(productIdRange: ProductIdRange): List<Long> {
        if (productIdRange.start.length % 2 == 1 && productIdRange.end.length % 2 == 1 &&
            productIdRange.start.length == productIdRange.end.length) {
            return emptyList()
        }

        val invalidProductIds = mutableListOf<Long>()
        val start = productIdRange.start.toLong()
        val end = productIdRange.end.toLong()

        for (num in start .. end) {
            val numStr = num.toString()
            if (numStr.length % 2 == 1) {
                continue
            }

            val firstHalf = numStr.substring(0..<(numStr.length / 2))
            val secondHalf = numStr.substring((numStr.length / 2) .. numStr.lastIndex)

            if (firstHalf == secondHalf) {
                invalidProductIds.add(numStr.toLong())
            }
        }

        return invalidProductIds
    }
}