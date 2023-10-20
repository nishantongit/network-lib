package com.example.androidrnd.data.model.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmployeeListResponse(
    var status: String? = null,
    @Json(name = "data") var data: List<Data> = arrayListOf(),
    @Json(name = "message") var message: String? = null
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "employee_name") var employeeName: String? = null,
    @Json(name = "employee_salary") var employeeSalary: Int? = null,
    @Json(name = "employee_age") var employeeAge: Int? = null,
    @Json(name = "profile_image") var profileImage: String? = null
)