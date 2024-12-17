package com.oligue.app.beerace

import android.app.Application
import com.oligue.app.beerace.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BeeRaceApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BeeRaceApplication)
            modules(appModules)
        }
    }
}