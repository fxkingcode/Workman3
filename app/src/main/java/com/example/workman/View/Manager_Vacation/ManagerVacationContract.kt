package com.example.workman.View.Manager_Vacation

import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem

interface ManagerVacationContract {
    interface IManagerVacationPresenter{
        fun myVacation()
        fun employeeVacation()
        fun waitingVacation()
    }

    interface IManagerVacationView{
        fun myButtonEnable(boolean: Boolean)
        fun employeeButtonEnable(boolean: Boolean)
        fun waitingButtonEnable(boolean: Boolean)
        fun changeMyFragemnt()
        fun changeEmployeeFragemnt()
        fun changeWaitingFragemnt()
        fun setMyBackground(id:Int?)
        fun setEmployeeBackground(id:Int?)
        fun setWaitingBackground(id:Int?)
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
    }
}