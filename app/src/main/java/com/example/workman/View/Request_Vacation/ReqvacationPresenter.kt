package com.example.workman.View.Request_Vacation

import android.content.Context
import com.example.workman.Model.DAO.VacationModel
import com.example.workman.Model.DTO.VacationItem
import com.prolificinteractive.materialcalendarview.CalendarDay

class ReqvacationPresenter(
    private val context: Context,
    val view: ReqvacationContract.IReqvacationView
):ReqvacationContract.IReqvacationPresenter,ReqvacationContract.Listener {

    private var vacationModel: VacationModel =
        VacationModel()

    override fun startTimeClick() {
        view.createTimePicker("시작 시간")
    }

    override fun setStartTime(h:Int,m:Int)
    {
        if(h < 12)
        {
            if(h < 10)
            {
                if(m < 10)
                {
                    view.startTimeText("AM 0$h:0$m")
                }
                else
                {
                    view.startTimeText("AM 0$h:$m")
                }
            }
            else
            {
                if(m < 10)
                {
                    view.startTimeText("AM $h:0$m")
                }
                else
                {
                    view.startTimeText("AM $h:$m")
                }
            }
        }
        else
        {
            val pmH:Int = h-12
            if(pmH < 10)
            {
                if(m < 10)
                {
                    view.startTimeText("PM 0$pmH:0$m")
                }
                else
                {
                    view.startTimeText("PM 0$pmH:$m")
                }
            }
            else
            {
                if(m < 10)
                {
                    view.startTimeText("PM $pmH:0$m")
                }
                else
                {
                    view.startTimeText("PM $pmH:$m")
                }
            }
        }
    }

    override fun setEndTime(h:Int,m:Int)
    {
        if(h < 12)
        {
            if(h < 10)
            {
                if(m < 10)
                {
                    view.endTimeText("AM 0$h:0$m")
                }
                else
                {
                    view.endTimeText("AM 0$h:$m")
                }
            }
            else
            {
                if(m < 10)
                {
                    view.endTimeText("AM $h:0$m")
                }
                else
                {
                    view.endTimeText("AM $h:$m")
                }
            }
        }
        else
        {
            val pmH:Int = h-12
            if(pmH < 10)
            {
                if(m < 10)
                {
                    view.endTimeText("PM 0$pmH:0$m")
                }
                else
                {
                    view.endTimeText("PM 0$pmH:$m")
                }
            }
            else
            {
                if(m < 10)
                {
                    view.endTimeText("PM $pmH:0$m")
                }
                else
                {
                    view.endTimeText("PM $pmH:$m")
                }
            }
        }
    }

    override fun endTimeClick() {
        view.createTimePicker("종료 시간")
    }

    override fun applyActivate(selectedDates: Int) {
        if(selectedDates == 0)
        {
            view.applyEnable(false)
        }
        else
        {
            view.applyEnable(true)
        }
    }

    override fun timeActivate(type:String)
    {
        if(type == "반차")
        {
            view.startTimeEnable(true)
            view.endTimeEnable(true)
        }
        else
        {
            view.startTimeEnable(false)
            view.endTimeEnable(false)
        }
    }

    override fun onSuccess() {
        view.progressInvisible()
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun apply(dates:List<CalendarDay>,type: String,startTime:String?,endTime:String?,reason:String?) {
        val email:String = "이메일"
        val name:String = "이름"
        for(i in dates.indices)
        {
            val vacationItem: VacationItem = VacationItem(null,name,type,dates[i].date,false,null,null,startTime,endTime,reason,email)
            vacationModel.vacationRequest(vacationItem,this)
        }
    }
}