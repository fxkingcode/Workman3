package com.example.workman.View.Employee

import android.content.Context
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem
import java.util.ArrayList

interface EmployeeContract {
    interface IEmployeePresenter{
        var adapterActiveModel: EmployeeAdapterContract.Model?
        var adapterActiveView: EmployeeAdapterContract.View?
        var adapterPassiveModel: EmployeeAdapterContract.Model?
        var adapterPassiveView: EmployeeAdapterContract.View?
        fun activeEmployee()
        fun passiveEmployee()
    }

    interface IEmployeeView{
        fun detailEmployee(idx:Int)
        fun activeButtonEnable(boolean: Boolean)
        fun passiveButtonEnable(boolean: Boolean)
        fun changeActiveAdapter()
        fun changePassiveAdapter()
        fun setActiveBackground(id:Int?)
        fun setPassiveBackground(id:Int?)
        fun finishActivity()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onActiveSuccess(context: Context, result: ArrayList<EmployeeDto>)
        fun onPassiveSuccess(context: Context, result: ArrayList<EmployeeDto>)
        fun onFailure()
    }
}