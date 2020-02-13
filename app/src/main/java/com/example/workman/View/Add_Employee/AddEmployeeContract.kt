package com.example.workman.View.Add_Employee

import android.content.Context
import android.content.Intent
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.SelectGroupData
import java.util.ArrayList

interface AddEmployeeContract {
    interface IAddEmployeePresenter{
        fun nameChange(text: String)
        fun groupClick()
        fun groupClickResult(data: Intent?)
        fun create(name:String,position:String,group:ArrayList<SelectGroupData>?,email:String?,phoneNum:String?,invite:Boolean,memo:String?)
    }

    interface IAddEmployeeView{
        fun setGroupButtonText(text: String)
        fun addGroupArray(arrayList: ArrayList<SelectGroupData>)
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
        fun selectGroup()
        fun activeCreate(boolean: Boolean)
        fun checkAlpha(float: Float)
        fun createAlpha(float: Float)
    }

    interface Listener
    {
        fun onSuccess()
        fun onFailure()
    }
}