package com.example.workman.View.Detail_Employee

import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData

interface DetailEmployeeContract {
    interface IDetailEmployeePresenter{
        fun callEmployee(idx:Int)
        fun modifyClick()
    }

    interface IDetailEmployeeView{
        fun getGroupText():String
        fun modifyEmployee(employee:EmployeeDto,groupCheckArray:ArrayList<SelectGroupData>)
        fun setNameText(text: String)
        fun setPositionText(text: String)
        fun setGroupText(text: String)
        fun setEmailText(text: String)
        fun setPhoneText(text: String)
        fun setMemoText(text: String)
        fun setStateText(text: String)
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess(employee: EmployeeDto)
        fun onFailure()
        fun onGroupSuccess(group:GroupDto)
        fun onGroupFailure()
    }
}