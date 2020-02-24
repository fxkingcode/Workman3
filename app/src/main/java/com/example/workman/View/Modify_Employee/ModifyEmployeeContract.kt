package com.example.workman.View.Modify_Employee

import android.content.Intent
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.SelectGroupData
import kotlinx.android.synthetic.main.activity_modify_employee.*
import kotlin.collections.ArrayList

interface ModifyEmployeeContract {
    interface IModifyEmployeePresenter {
        fun modifySave()
        fun getIntent(intent: Intent)
        fun nameChange(text: String)
        fun groupClick()
        fun groupClickResult(data: Intent?)
        fun activeChange(boolean: Boolean)
    }

    interface IModifyEmployeeView {
        fun setActiveButtonVisible(boolean: Boolean)
        fun setInactiveButtonVisible(boolean: Boolean)
        fun setNameText(text: String)
        fun setPositionText(text: String)
        fun setEmailText(text: String)
        fun setPhoneText(text: String)
        fun setMemoText(text: String)
        fun setGroupButtonText(text: String)
        fun addGroupArray(arrayList: ArrayList<SelectGroupData>)
        fun selectGroup()
        fun activeSave(boolean: Boolean)
        fun checkAlpha(float: Float)
        fun saveAlpha(float: Float)
        fun finishActivity()
        fun progressVisible(boolean: Boolean)
        fun toastMessage(text: String)
    }

    interface Listener {
        fun onSuccess()
        fun onFailure()
        fun onActiveSuccess(boolean: Boolean)
        fun onActiveFailure()
    }
}