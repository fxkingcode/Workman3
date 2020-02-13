package com.example.workman.View.Detail_Group

import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData

interface DetailGroupContract {
    interface IDetailGroupPresenter{
        fun callGroup(idx:Int)
        fun modifyClick()
    }

    interface IDetailGroupView{
        fun finishActivity()
        fun progressVisible(boolean: Boolean)
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess(employee: EmployeeDto)
        fun onFailure()
        fun onEmployeeSuccess(group: GroupDto)
        fun onEmployeeFailure()
    }
}