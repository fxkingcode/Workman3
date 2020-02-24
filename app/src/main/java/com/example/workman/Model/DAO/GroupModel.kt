package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.View.Detail_Employee.DetailEmployeeContract
import com.example.workman.View.Detail_Group.DetailGroupContract
import com.example.workman.View.Group.GroupContract
import com.example.workman.View.Select_Group.SelectGroupContract

class GroupModel {

    fun modifyGroup()
    {

    }

    fun callGroups(
        context: Context,
        companyId: String,
        listener: GroupContract.Listener
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId

        //api통신 여기서.

        var arrayList = ArrayList<String>()
        arrayList.add("직원1")
        arrayList.add("직원2")
        arrayList.add("직원3")
        arrayList.add("직원4")
        arrayList.add("직원5")
        arrayList.add("직원6")
        arrayList.add("직원7")
        arrayList.add("직원8")
        arrayList.add("직원9")
        arrayList.add("직원10")

        val items = ArrayList<GroupDto>()
        items.add(GroupDto(1, "그룹1", "빨간색", "메모",arrayList))
        items.add(GroupDto(2, "그룹2", "검은색", "메모",arrayList))
        items.add(GroupDto(3, "그룹3", "민트색", "메모",arrayList))
        items.add(GroupDto(4, "그룹4", "파란색", "메모",arrayList))
        items.add(GroupDto(5, "그룹5", "초록색", "메모",arrayList))
        items.add(GroupDto(6, "그룹6", "회색", "메모",arrayList))
        items.add(GroupDto(7, "그룹7", "검은색", "메모",arrayList))
        items.add(GroupDto(8, "그룹8", "빨간색", "메모",arrayList))
        items.add(GroupDto(9, "그룹9", "민트색", "메모",arrayList))
        items.add(GroupDto(10, "그룹10", "검은색", "메모",arrayList))
        items.add(GroupDto(11, "그룹11", "민트색", "메모",arrayList))
        items.add(GroupDto(12, "그룹12", "빨간색", "메모",arrayList))
        items.add(GroupDto(13, "그룹13", "빨간색", "메모",arrayList))
        items.add(GroupDto(14, "그룹14", "회색", "메모",arrayList))
        items.add(GroupDto(15, "그룹15", "초록색", "메모",arrayList))
        items.add(GroupDto(16, "그룹16", "파란색", "메모",arrayList))
        items.add(GroupDto(17, "그룹17", "빨간색", "메모",arrayList))
        items.add(GroupDto(18, "그룹18", "파란색", "메모",arrayList))
        items.add(GroupDto(19, "그룹19", "빨간색", "메모",arrayList))
        items.add(GroupDto(20, "그룹20", "초록색", "메모",arrayList))
        items.add(GroupDto(21, "그룹21", "파란색", "메모",arrayList))
        items.add(GroupDto(101, "그룹101", "빨간색", "메모",arrayList))
        items.add(GroupDto(102, "그룹102", "빨간색", "메모",arrayList))
        items.add(GroupDto(103, "그룹103", "초록색", "메모",arrayList))
        items.add(GroupDto(104, "그룹104", "민트색", "메모",arrayList))
        items.add(GroupDto(105, "그룹105", "빨간색", "메모",arrayList))
        items.add(GroupDto(106, "그룹106", "민트색", "메모",arrayList))
        items.add(GroupDto(107, "그룹107", "검은색", "메모",arrayList))
        items.add(GroupDto(108, "그룹108", "빨간색", "메모",arrayList))
        items.add(GroupDto(109, "그룹109", "초록색", "메모",arrayList))
        items.add(GroupDto(110, "그룹110", "검은색", "메모",arrayList))
        items.add(GroupDto(111, "그룹111", "빨간색", "메모",arrayList))
        items.add(GroupDto(112, "그룹112", "파란색", "메모",arrayList))

        listener.onSuccess(context, items)
    }

    fun callGroups(
        context: Context,
        companyId: String,
        listener: SelectGroupContract.Listener
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId

        //api통신 여기서.

        var arrayList = ArrayList<String>()
        arrayList.add("직원1")
        arrayList.add("직원2")
        arrayList.add("직원3")
        arrayList.add("직원4")
        arrayList.add("직원5")
        arrayList.add("직원6")
        arrayList.add("직원7")
        arrayList.add("직원8")
        arrayList.add("직원9")
        arrayList.add("직원10")

        val items = ArrayList<GroupDto>()
        items.add(GroupDto(1, "그룹1", "빨간색", "메모",arrayList))
        items.add(GroupDto(2, "그룹2", "빨간색", "메모",arrayList))
        items.add(GroupDto(3, "그룹3", "빨간색", "메모",arrayList))
        items.add(GroupDto(4, "그룹4", "빨간색", "메모",arrayList))
        items.add(GroupDto(5, "그룹5", "빨간색", "메모",arrayList))
        items.add(GroupDto(6, "그룹6", "빨간색", "메모",arrayList))
        items.add(GroupDto(7, "그룹7", "빨간색", "메모",arrayList))
        items.add(GroupDto(8, "그룹8", "빨간색", "메모",arrayList))
        items.add(GroupDto(9, "그룹9", "빨간색", "메모",arrayList))
        items.add(GroupDto(10, "그룹10", "빨간색", "메모",arrayList))
        items.add(GroupDto(11, "그룹11", "빨간색", "메모",arrayList))
        items.add(GroupDto(12, "그룹12", "빨간색", "메모",arrayList))
        items.add(GroupDto(13, "그룹13", "빨간색", "메모",arrayList))
        items.add(GroupDto(14, "그룹14", "빨간색", "메모",arrayList))
        items.add(GroupDto(15, "그룹15", "빨간색", "메모",arrayList))
        items.add(GroupDto(16, "그룹16", "빨간색", "메모",arrayList))
        items.add(GroupDto(17, "그룹17", "빨간색", "메모",arrayList))
        items.add(GroupDto(18, "그룹18", "빨간색", "메모",arrayList))
        items.add(GroupDto(19, "그룹19", "빨간색", "메모",arrayList))
        items.add(GroupDto(20, "그룹20", "빨간색", "메모",arrayList))
        items.add(GroupDto(21, "그룹21", "빨간색", "메모",arrayList))
        items.add(GroupDto(101, "그룹101", "빨간색", "메모",arrayList))
        items.add(GroupDto(102, "그룹102", "빨간색", "메모",arrayList))
        items.add(GroupDto(103, "그룹103", "빨간색", "메모",arrayList))
        items.add(GroupDto(104, "그룹104", "빨간색", "메모",arrayList))
        items.add(GroupDto(105, "그룹105", "빨간색", "메모",arrayList))
        items.add(GroupDto(106, "그룹106", "빨간색", "메모",arrayList))
        items.add(GroupDto(107, "그룹107", "빨간색", "메모",arrayList))
        items.add(GroupDto(108, "그룹108", "빨간색", "메모",arrayList))
        items.add(GroupDto(109, "그룹109", "빨간색", "메모",arrayList))
        items.add(GroupDto(110, "그룹110", "빨간색", "메모",arrayList))
        items.add(GroupDto(111, "그룹111", "빨간색", "메모",arrayList))
        items.add(GroupDto(112, "그룹112", "빨간색", "메모",arrayList))

        listener.onSuccess(context, items)
    }

    fun callGroup(
        context: Context,
        companyId: String,
        groupId: Int,
        listener: DetailGroupContract.Listener
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId
        params["group"] = groupId

        //api통신 여기서.

        var arrayList = ArrayList<String>()
        arrayList.add("직원1")
        arrayList.add("직원2")
        arrayList.add("직원3")
        arrayList.add("직원4")
        arrayList.add("직원5")
        arrayList.add("직원6")
        arrayList.add("직원7")
        arrayList.add("직원8")
        arrayList.add("직원9")
        arrayList.add("직원10")

        val groupDto: GroupDto = GroupDto(110, "그룹110", "빨간색", "메모",arrayList)

        listener.onSuccess(groupDto)
    }

    fun callGroup(
        context: Context,
        companyId: String,
        groupId: String,
        listener: DetailEmployeeContract.Listener
    ) {//오버로딩
        val params = HashMap<String, Any>()

        params["Company"] = companyId
        params["group"] = groupId

        //api통신 여기서.

        var arrayList = ArrayList<String>()
        arrayList.add("직원1")
        arrayList.add("직원2")
        arrayList.add("직원3")
        arrayList.add("직원4")
        arrayList.add("직원5")
        arrayList.add("직원6")
        arrayList.add("직원7")
        arrayList.add("직원8")
        arrayList.add("직원9")
        arrayList.add("직원10")

        val groupDto: GroupDto = GroupDto(110, "그룹110", "빨간색", "메모",arrayList)

        listener.onGroupSuccess(groupDto)
    }


}