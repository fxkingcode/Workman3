package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.View.Employee.EmployeeContract
import com.example.workman.View.SelectGroup.SelectGroupContract

class GroupModel {
    fun callGroups(
        context: Context,
        companyId:String,
        listener: SelectGroupContract.Listener
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId

        //api통신 여기서.

        val items = ArrayList<GroupDto>()
        items.add(GroupDto(1,"그룹1","빨간색","메모"))
        items.add(GroupDto(2,"그룹2","빨간색","메모"))
        items.add(GroupDto(3,"그룹3","빨간색","메모"))
        items.add(GroupDto(4,"그룹4","빨간색","메모"))
        items.add(GroupDto(5,"그룹5","빨간색","메모"))
        items.add(GroupDto(6,"그룹6","빨간색","메모"))
        items.add(GroupDto(7,"그룹7","빨간색","메모"))
        items.add(GroupDto(8,"그룹8","빨간색","메모"))
        items.add(GroupDto(9,"그룹9","빨간색","메모"))
        items.add(GroupDto(10,"그룹10","빨간색","메모"))
        items.add(GroupDto(11,"그룹11","빨간색","메모"))
        items.add(GroupDto(12,"그룹12","빨간색","메모"))
        items.add(GroupDto(13,"그룹13","빨간색","메모"))
        items.add(GroupDto(14,"그룹14","빨간색","메모"))
        items.add(GroupDto(15,"그룹15","빨간색","메모"))
        items.add(GroupDto(16,"그룹16","빨간색","메모"))
        items.add(GroupDto(17,"그룹17","빨간색","메모"))
        items.add(GroupDto(18,"그룹18","빨간색","메모"))
        items.add(GroupDto(19,"그룹19","빨간색","메모"))
        items.add(GroupDto(20,"그룹20","빨간색","메모"))
        items.add(GroupDto(21,"그룹21","빨간색","메모"))

        listener.onSuccess(context,items)
    }
}