package com.github.jacloc.weddingapp.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initializeKoin(appDeclaration: KoinAppDeclaration): KoinApplication = startKoin {
    appDeclaration()
    modules(sharedModule, platformModule)
}