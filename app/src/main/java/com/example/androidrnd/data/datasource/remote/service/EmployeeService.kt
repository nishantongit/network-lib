package com.example.androidrnd.data.datasource.remote.service

import com.example.androidrnd.data.model.remote.EmployeeListResponse
import com.nishant.network.network.NetworkResult
import retrofit2.http.GET


interface EmployeeService {
    @GET("/api/v1/employees")
    suspend fun getItems(): NetworkResult<EmployeeListResponse>
}