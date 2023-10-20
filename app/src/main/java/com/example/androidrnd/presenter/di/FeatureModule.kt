package com.example.androidrnd.presenter.di

import com.example.androidrnd.base.di.ViewModelFactory
import com.example.androidrnd.data.datasource.remote.api.ApiClient
import com.example.androidrnd.data.datasource.remote.service.EmployeeService
import com.example.androidrnd.data.repository.EmployeeRepositoryImpl
import com.example.androidrnd.domain.repository.EmployeeRepository
import com.example.androidrnd.domain.usecase.GetEmployeeList
import dagger.Module
import dagger.Provides


@Module
class FeatureModule() {

    @Provides
    fun provideItemsService(): EmployeeService {
        return ApiClient.getService()
    }

    @Provides
    fun provideRepository(service: EmployeeService): EmployeeRepository {
        return EmployeeRepositoryImpl(service)
    }

    @Provides
    fun provideUseCase(repo:EmployeeRepository): GetEmployeeList {
        return GetEmployeeList(repo)
    }

    @Provides
    fun provideViewMOdelFactory(useCase:GetEmployeeList): ViewModelFactory {
        return ViewModelFactory(useCase)
    }

}