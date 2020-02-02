package com.example.workman.View.Manager_Vacation

import android.content.Context
import com.example.workman.R
import com.example.workman.View.Detail_Vacation.DetailvacaContract

class ManagerVacationPresenter(
    private val context: Context,
    val view: ManagerVacationContract.IManagerVacationView
) : ManagerVacationContract.IManagerVacationPresenter {

    override fun employeeVacation() {
        view.changeEmployeeFragemnt()
        view.setEmployeeBackground(R.drawable.bottomline)
        view.setMyBackground(null)
        view.setWaitingBackground(null)
//        view.employeeButtonEnable(false)
//        view.myButtonEnable(true)
//        view.waitingButtonEnable(true)
    }

    override fun waitingVacation() {
        view.changeWaitingFragemnt()
        view.setWaitingBackground(R.drawable.bottomline)
        view.setEmployeeBackground(null)
        view.setMyBackground(null)
//        view.waitingButtonEnable(false)
//        view.myButtonEnable(true)
//        view.employeeButtonEnable(true)
    }

    override fun myVacation() {
        view.changeMyFragemnt()
        view.setMyBackground(R.drawable.bottomline)
        view.setEmployeeBackground(null)
        view.setWaitingBackground(null)
//        view.myButtonEnable(false)
//        view.employeeButtonEnable(true)
//        view.waitingButtonEnable(true)
    }

}