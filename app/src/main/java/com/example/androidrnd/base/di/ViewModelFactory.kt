package com.example.androidrnd.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidrnd.domain.usecase.GetEmployeeList
import com.example.androidrnd.presenter.viewmodel.EmployeeListVIewModel


class ViewModelFactory(private val getItems: GetEmployeeList) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(EmployeeListVIewModel::class.java) -> EmployeeListVIewModel(
                getItems
            ) as T
            else -> throw java.lang.IllegalArgumentException("No ViewModel Found")
        }
    }
}