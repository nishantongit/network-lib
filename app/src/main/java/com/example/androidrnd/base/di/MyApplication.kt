package com.example.androidrnd.base.di

import android.app.Application

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.Initializer.init(this)
    }
}