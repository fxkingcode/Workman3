package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.View.Detail_Employee.DetailEmployeeContract
import com.example.workman.View.Employee.EmployeeContract
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class EmployeeModel {

    fun callEmployee(idx: Int, listener: DetailEmployeeContract.Listener) {
        val params = HashMap<String, Any>()

        params["Company"] = "company"
        params["idx"] = idx

        //api통신 여기서

        val arrayList = ArrayList<String>()
        arrayList.add("groupUid1")

        listener.onSuccess(
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
        context: Context,
        companyId: String,
        listener: EmployeeContract.Listener,
        isActive: Boolean
    ) {

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
}