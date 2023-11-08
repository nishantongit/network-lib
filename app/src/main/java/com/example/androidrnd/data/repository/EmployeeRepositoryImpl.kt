package com.example.androidrnd.data.repository

import com.example.androidrnd.data.datasource.remote.service.EmployeeService
import com.example.androidrnd.data.model.remote.EmployeeListResponse
import com.example.androidrnd.domain.repository.EmployeeRepository
import com.nishant.network.network.NetworkResult

class EmployeeRepositoryImpl(val service: EmployeeService):EmployeeRepository {
    override suspend fun getEmployeeList(): NetworkResult<EmployeeListResponse> {
        return service.getItems()

//        if (response.isSuccessful) {
//            return NetworkResult.Success<EmployeeListResponse>(response.body()!!)
//        } else {
//            return NetworkResult.Error(404,"dcd")
//        }
    }
}