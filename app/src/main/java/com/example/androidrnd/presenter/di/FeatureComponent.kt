package com.example.androidrnd.presenter.di

import android.content.Context
import com.example.androidrnd.presenter.view.EmployeeLIstFragment
import dagger.Component

@Component(modules = [FeatureModule::class])
interface FeatureComponent {
    fun inject(fragment : EmployeeLIstFragment)

    companion object Initializer{
        fun init(context: Context): FeatureComponent {
            val featureModule = FeatureModule()
            return DaggerFeatureComponent.builder()
                .featureModule(featureModule).build()
        }
    }
}