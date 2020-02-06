package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.View.Employee.EmployeeContract
import com.example.workman.View.Waiting_Vacation.WaitingVacationContract
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class EmployeeModel {
    fun callEmployees(
        context: Context,
        companyId:String,
        listener: EmployeeContract.Listener,
        isActive:Boolean
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId

        //api통신 여기서.

        if(isActive)
        {
            val items = ArrayList<EmployeeDto>()
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",true,"메모",true))
            items.add(EmployeeDto(0,"고길동","중간 관리자","그룹","이메일","0",true,"메모",false))
            items.add(EmployeeDto(0,"홍길동","최고 관리자","그룹","이메일","0",true,"메모",true))
            items.add(EmployeeDto(0,"고길동","중간 관리자","그룹","이메일","0",true,"메모",true))
            items.add(EmployeeDto(0,"고길동","중간 관리자","그룹","이메일","0",true,"메모",false))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",true,"메모",true))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",true,"메모",false))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",true,"메모",false))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",true,"메모",true))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",true,"메모",true))

            listener.onActiveSuccess(context, items)
        }
        else
        {
            val items = ArrayList<EmployeeDto>()
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",false,"메모",true))
            items.add(EmployeeDto(0,"고길동","중간 관리자","그룹","이메일","0",false,"메모",false))
            items.add(EmployeeDto(0,"고길동","중간 관리자","그룹","이메일","0",false,"메모",true))
            items.add(EmployeeDto(0,"고길동","중간 관리자","그룹","이메일","0",false,"메모",false))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",false,"메모",true))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",false,"메모",false))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",false,"메모",false))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",false,"메모",true))
            items.add(EmployeeDto(0,"김수완무","직원","그룹","이메일","0",false,"메모",true))

            listener.onPassiveSuccess(context, items)
        }
    }
}