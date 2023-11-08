package com.example.androidrnd.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidrnd.domain.usecase.GetEmployeeList
import com.nishant.network.network.NetworkResult

class EmployeeListVIewModel(val getEmployeeList: GetEmployeeList):ViewModel() {

    suspend fun onLoad(){
        when(val result = getEmployeeList.invoke()){
            is NetworkResult.Error -> {
                Log.d("onResult", result.toString())
            }

            is NetworkResult.Exception -> {

            }
            is NetworkResult.Success -> {
                Log.d("onResult", result.data.toString())
                result.toString()
            }
        }
    }
}