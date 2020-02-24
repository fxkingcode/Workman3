package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Api.ServiceGenerator
import com.example.workman.Model.DTO.DefaultResponse
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.View.Add_Employee.AddEmployeeContract
import com.example.workman.View.Detail_Employee.DetailEmployeeContract
import com.example.workman.View.Detail_Group.DetailGroupContract
import com.example.workman.View.Employee.EmployeeContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class EmployeeModel(context: Context) {

    val serviceGenerator: ServiceGenerator = ServiceGenerator(context)

    fun callEmployee(idx: Int, listener: DetailEmployeeContract.Listener) {
        val params = HashMap<String, Any>()

        params["Company"] = "company"
        params["idx"] = idx

//        //api통신 여기서
        serviceGenerator.instance.callEmployee(params).enqueue(object : Callback<EmployeeDto> {
            override fun onFailure(call: Call<EmployeeDto>, t: Throwable) {
                listener.onFailure()
            }

            override fun onResponse(call: Call<EmployeeDto>, response: Response<EmployeeDto>) {
                response.body()?.let { listener.onSuccess(it) }
            }
        })
    }

    fun callEmployee(idx: String, listener: DetailGroupContract.Listener) {
        val params = HashMap<String, Any>()

        params["Company"] = "company"
        params["idx"] = idx

        //api통신 여기서

        val arrayList = ArrayList<String>()
        arrayList.add("groupUid1")

        listener.onEmployeeSuccess(
            EmployeeDto(
                1,
                "김연준",
                "중간 관리자",
                arrayList,
                "Email",
                "010-1234-5678",
                true,
                "메에ㅔ에모",
                true
            )
        )
    }

    fun createEmployee(
        hashMap: HashMap<String, Any>,
        listener: AddEmployeeContract.Listener
    ) {
        serviceGenerator.instance.addEmployee(hashMap).enqueue(object : Callback<DefaultResponse> {
            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                println("오류 : $t")
                listener.onFailure()
            }

            override fun onResponse(
                call: Call<DefaultResponse>,
                response: Response<DefaultResponse>
            ) {
                if(response.body()?.type!!)
                {
                    listener.onSuccess()
                }else {
                    listener.onFailure()
                    println("실패 : " + response.body()?.data)
                }
            }
        })
    }

    fun callEmployees(
        context: Context,
        companyId: String,
        listener: EmployeeContract.Listener,
        isActive: Boolean
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId
        val arrayList = ArrayList<String>()
        arrayList.add("groupUid1")
        arrayList.add("groupUid2")
        arrayList.add("groupUid3")
        arrayList.add("groupUid4")

        //api통신 여기서.

        if (isActive) {
            val items = ArrayList<EmployeeDto>()
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", true, "메모", true))
            items.add(EmployeeDto(0, "고길동", "중간 관리자", arrayList, "이메일", "0", true, "메모", false))
            items.add(EmployeeDto(0, "홍길동", "최고 관리자", arrayList, "이메일", "0", true, "메모", true))
            items.add(EmployeeDto(0, "고길동", "중간 관리자", arrayList, "이메일", "0", true, "메모", true))
            items.add(EmployeeDto(0, "고길동", "중간 관리자", arrayList, "이메일", "0", true, "메모", false))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", true, "메모", true))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", true, "메모", false))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", true, "메모", false))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", true, "메모", true))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", true, "메모", true))

            listener.onActiveSuccess(context, items)
        } else {
            val items = ArrayList<EmployeeDto>()
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", false, "메모", true))
            items.add(EmployeeDto(0, "고길동", "중간 관리자", arrayList, "이메일", "0", false, "메모", false))
            items.add(EmployeeDto(0, "고길동", "중간 관리자", arrayList, "이메일", "0", false, "메모", true))
            items.add(EmployeeDto(0, "고길동", "중간 관리자", arrayList, "이메일", "0", false, "메모", false))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", false, "메모", true))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", false, "메모", false))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", false, "메모", false))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", false, "메모", true))
            items.add(EmployeeDto(0, "김수완무", "직원", arrayList, "이메일", "0", false, "메모", true))

            listener.onPassiveSuccess(context, items)
        }
    }

    fun modifyEmployee() {

    }
}