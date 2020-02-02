package com.example.workman.View.Employee_Vacation

import android.content.Context
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DTO.VacationItem
import com.prolificinteractive.materialcalendarview.CalendarDay
import java.util.*

interface EmployeeVacationContract {
    interface IEmployeeVacationPresenter{
        var adapterModel: VacationAdapterContract.Model?
        var adapterView: VacationAdapterContract.View?
        fun callItems(firstDate: Date,lastDate:Date,isclear:Boolean)
        fun calendarButtonClick()
        fun calendarButtonTextFormat(startDate: Date, endDate: Date)
    }

    interface IEmployeeVacationView{
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
        fun detailVacation(idx:Int)
        fun setCalendarVisible()
        fun setCalendarButtonText(text:String)
    }

    interface Listener
    {
        fun onSuccess(context: Context, result:ArrayList<VacationItem>)
        fun onFailure()
    }
}