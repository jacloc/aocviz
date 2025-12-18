package com.github.jacloc.weddingapp.di

import com.github.jacloc.android.aocviz.DayRoute
import com.github.jacloc.android.aocviz.viewmodel.CalendarViewModel
import com.github.jacloc.android.aocviz.viewmodel.DayViewModel
import com.github.jacloc.android.aocviz.viewmodel.features.DayFeature
import com.github.jacloc.android.aocviz.viewmodel.features.DayFeature01
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

    // Feature/ViewModel
    viewModelOf(::CalendarViewModel)
    viewModel {
        DayViewModel(
            get(),
            get()
        )
    }

    singleOf(::DayFeature01)

    single<Map<Int, DayFeature>> {
        mapOf(
            1 to get<DayFeature01>(),
        )
    }
}