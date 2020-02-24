package com.example.workman.Api

import com.example.workman.Model.DTO.DefaultResponse
import com.example.workman.Model.DTO.EmployeeDto
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST(IPAdress.router.addVacation)
    fun addVacation(
        @FieldMap hashMap: HashMap<String,Any>
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST(IPAdress.router.addEmployee)
    fun addEmployee(
        @FieldMap hashMap: HashMap<String,Any>
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST(IPAdress.router.addEmployee)
    fun callEmployee(
        @FieldMap hashMap: HashMap<String,Any>
    ):Call<EmployeeDto>
}