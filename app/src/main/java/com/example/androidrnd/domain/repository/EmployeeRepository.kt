package com.example.androidrnd.domain.repository

import com.example.androidrnd.data.model.remote.EmployeeListResponse
import com.example.network.NetworkResult


interface EmployeeRepository {
    suspend fun getEmployeeList(): NetworkResult<EmployeeListResponse>
}