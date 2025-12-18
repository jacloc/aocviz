package com.github.jacloc.android.aocviz

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform