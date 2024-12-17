package com.oligue.app.beerace.di

import com.oligue.app.beerace.data.repositories.BeeRaceRepository
import com.oligue.app.beerace.data.repositories.BeeRaceRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<BeeRaceRepository> {
        BeeRaceRepositoryImpl(
            beeAPI = get()
        )
    }
}