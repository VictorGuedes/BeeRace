package com.oligue.app.beerace.di

import com.oligue.app.beerace.data.services.BeeAPI
import com.oligue.app.beerace.data.services.ErrorInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .addInterceptor(ErrorInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://rtest.proxy.beeceptor.com/bees/race/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(BeeAPI::class.java)
    }
}

val appModules = listOf(
    appModule,
    repositoryModule,
    viewModelModule
)