package com.github.jacloc.weddingapp.di

import com.github.jacloc.android.aocviz.viewmodel.CalendarViewModel
import com.github.jacloc.android.aocviz.viewmodel.SolutionViewModel
import com.github.jacloc.android.aocviz.viewmodel.features.Solution
import com.github.jacloc.android.aocviz.viewmodel.features.solution01.Solution01
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule: Module get() = module {
    // Network
//    single {
//        HttpClient {
//            install(ContentNegotiation) {
//                json(Json {
//                    prettyPrint = true
//                    isLenient = true
//                    ignoreUnknownKeys = true
//                })
//            }
//            defaultRequest {
//                url("http://192.168.1.159:8080")
//            }
//        }
//    }

    //Repository
//    singleOf(::AppContentRepository)

    // ViewModel
    viewModelOf(::CalendarViewModel)
    viewModel {
        SolutionViewModel(
            get(),
            get()
        )
    }

    // Features (days)
    singleOf(::Solution01)
    single<Map<Int, Solution>> {
        mapOf(
            1 to get<Solution01>(),
        )
    }
}