package com.example.workman.View.SelectGroup

import android.content.Context
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupCheck
import com.example.workman.Model.DTO.GroupDto
import com.prolificinteractive.materialcalendarview.CalendarDay
import java.util.ArrayList

interface SelectGroupContract {
    interface ISelectGroupPresenter{
        var adapterModel: GroupAdapterContract.Model?
        var adapterView: GroupAdapterContract.View?
        fun complete()
        fun callGroups()
        fun allSelectClick(boolean: Boolean)
    }

    interface ISelectGroupView{
        fun finishActivity(arrayList: ArrayList<GroupCheck>)
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess(context: Context, result: ArrayList<GroupDto>)
        fun onFailure()
    }
}