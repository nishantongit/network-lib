package com.example.androidrnd.domain.usecase

import com.example.androidrnd.data.model.remote.EmployeeListResponse
import com.example.androidrnd.domain.repository.EmployeeRepository
import com.nishant.network.network.NetworkResult

class GetEmployeeList(private val repo:EmployeeRepository) {

    public suspend  operator fun  invoke(): NetworkResult<EmployeeListResponse> {
        return repo.getEmployeeList()
    }

}