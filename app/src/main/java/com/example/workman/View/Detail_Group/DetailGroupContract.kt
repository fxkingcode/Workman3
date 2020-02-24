package com.example.workman.View.Detail_Group

import android.content.Intent
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData

interface DetailGroupContract {
    interface IDetailGroupPresenter {
        fun callGroup()
        fun modifyClick()
        fun getIntent(intent: Intent)
    }

    interface IDetailGroupView
    {
        fun modifyGroup(group:GroupDto)
        fun setNameText(text: String)
        fun setMarkerText(text: String)
        fun setMarkerBackground(int: Int)
        fun setMemoText(text: String)
        fun setPersonnelText(text: String)
        fun setEmployeesText(text: String)
        fun finishActivity()
        fun progressVisible(boolean: Boolean)
        fun toastMessage(text: String)
    }

    interface Listener {
        fun onSuccess(group: GroupDto)
        fun onFailure()
        fun onEmployeeSuccess(employeeDto: EmployeeDto)
        fun onEmployeeFailure()
    }
}