package com.example.androidrnd.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidrnd.domain.usecase.GetEmployeeList
import com.example.network.NetworkResult

class EmployeeListVIewModel(val getEmployeeList: GetEmployeeList):ViewModel() {

    suspend fun onLoad(){
        when(val result = getEmployeeList.invoke()){
            is NetworkResult.Error -> TODO()
            is NetworkResult.Exception -> TODO()
            is NetworkResult.Success -> {
                result.toString()
            }
        }
    }
}