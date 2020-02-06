package com.example.workman.Adapter.AdapterContract

import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem

interface EmployeeAdapterContract {
    interface View {
        var onClickFunc : ((Int) -> Unit)?//1급객체
        fun notifyAdapter()
    }

    interface Model {
        fun addItems(employeeItems:ArrayList<EmployeeDto>)
        fun clearItems()
        fun getItem(position:Int): EmployeeDto
    }
}