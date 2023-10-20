package com.example.androidrnd.base.di

import android.app.Application
import android.content.Context
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context(): Context
    fun applicationContext(): Application


    object Initializer {
        fun init(app: Application): AppComponent {
            val appModule = AppModule(app)
            return DaggerAppComponent.builder()
                .appModule(appModule).build()
        }
    }
}