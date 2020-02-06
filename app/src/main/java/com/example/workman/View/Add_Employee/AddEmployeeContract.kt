package com.example.workman.View.Add_Employee

import android.content.Context
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Model.DTO.EmployeeDto
import java.util.ArrayList

interface AddEmployeeContract {
    interface IAddEmployeePresenter{

    }

    interface IAddEmployeeView{
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess()
        fun onFailure()
    }
}