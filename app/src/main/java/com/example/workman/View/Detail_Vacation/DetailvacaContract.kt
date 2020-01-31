package com.example.workman.View.Detail_Vacation

import com.example.workman.Model.DTO.VacationItem
import com.example.workman.Model.DTO.EmployeeDto

interface DetailvacaContract {
    interface IDetailvacaPresenter{
        fun callVacation(idx:Int)
        fun cancelVacation(idx:Int)
    }

    interface IDetailvacaView{
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
        fun setName(text:String)
        fun setType(text: String)
        fun setDate(date: String)
        fun setStartTime(text: String)
        fun setEndTime(text: String)
        fun setApprove(text: String)
        fun setApproveManager(text: String)
        fun setApproveTime(text: String)
        fun setApproveManagerText(text: String)
        fun setApproveTimeText(text: String)
        fun setReason(text: String)
        fun setApproveColor(color:Int)
        fun setTimeColor(color:Int)
        fun setButtonVisible(boolean: Boolean)
        fun getIdx():Int?
    }

    interface Listener
    {
        fun callVacationSuccess(vacation:VacationItem)
        fun callVacationSuccessFailure()
        fun cancelVacationSuccess()
        fun cancelVacationSuccessFailure()
    }
}