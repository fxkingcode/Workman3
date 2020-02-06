package com.example.workman.Adapter.AdapterContract

import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupCheck
import com.example.workman.Model.DTO.GroupDto

interface GroupAdapterContract {
    interface View {
        var onClickFunc : ((Int) -> Unit)?//1급객체
        fun notifyAdapter()
        fun allCheck(boolean: Boolean)
    }

    interface Model {
        fun addItems(groupItems:ArrayList<GroupDto>)
        fun clearItems()
        fun getItem(position:Int): GroupDto
        fun getCheckArray():ArrayList<GroupCheck>
    }
}