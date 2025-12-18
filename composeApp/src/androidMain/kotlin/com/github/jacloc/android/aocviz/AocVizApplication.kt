package com.github.jacloc.android.aocviz

import android.app.Application
import com.github.jacloc.weddingapp.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class AocVizApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@AocVizApplication)
        }
    }
}