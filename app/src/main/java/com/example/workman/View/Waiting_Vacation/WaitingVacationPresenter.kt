package com.example.workman.View.Waiting_Vacation

import android.content.Context
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DAO.VacationModel
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.View.My_Vacation.MyVacationContract
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class WaitingVacationPresenter (
    private val context: Context,
    val view: WaitingVacationContract.IWaitingVacationView
) : WaitingVacationContract.IWaitingVacationPresenter, WaitingVacationContract.Listener {

    private var vacationModel: VacationModel =
        VacationModel()

    override var adapterModel: VacationAdapterContract.Model? = null
    override var adapterView: VacationAdapterContract.View? = null
        set(value) {//커스텀 접근자
            field = value
            field?.onClickFunc = { onClickListener(it) }
        }

    override fun callItems(firstDate: Date, lastDate: Date, isclear: Boolean) {
        val email: String = "이메일"
        if (isclear) {
            adapterModel?.clearItems()
        }
        vacationModel.callVacations(context, email, this)
    }

    private fun onClickListener(position: Int) {
        adapterModel?.getItem(position).let {
            it?.id?.let { it1 -> view.detailVacation(it1) }
        }
    }

    override fun onSuccess(context: Context, result: ArrayList<VacationItem>) {
        adapterModel?.addItems(result)
        adapterView?.notifyAdapter()
        view.progressInvisible()
    }

    override fun onFailure() {
        view.progressInvisible()
    }
}