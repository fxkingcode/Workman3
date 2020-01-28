package com.example.workman.View.Request_Vacation

import android.content.Context
import android.widget.Spinner
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Data.VacationItem
import com.prolificinteractive.materialcalendarview.CalendarDay
import java.util.*
import kotlin.collections.ArrayList

interface ReqvacationContract {
    interface IReqvacationPresenter{
        fun applyActivate(selectedDates:Int)
        fun timeActivate(type:String)
        fun startTimeClick()
        fun endTimeClick()
        fun setStartTime(h:Int,m:Int)
        fun setEndTime(h:Int,m:Int)
        fun apply(dates:List<CalendarDay>,type: String,startTime:String?,endTime:String?,reason:String?)
    }

    interface IReqvacationView{
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
        fun applyEnable(boolean: Boolean)
        fun startTimeEnable(boolean: Boolean)
        fun endTimeEnable(boolean: Boolean)
        fun createTimePicker(message:String)
        fun startTimeText(text: String)
        fun endTimeText(text: String)
    }

    interface Listener
    {
        fun onSuccess()
        fun onFailure()
    }
}