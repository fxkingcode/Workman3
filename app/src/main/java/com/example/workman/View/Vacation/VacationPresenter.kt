package com.example.workman.View.Vacation

import android.content.Context
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.Model.DAO.VacationModel
import java.util.*
import kotlin.collections.ArrayList

class VacationPresenter(
    private val context: Context,
    val view: VacationContract.IVacationView
) : VacationContract.IVacationPresenter, VacationContract.Listener {

    private var vacationModel: VacationModel =
        VacationModel()
    override lateinit var adapterModel: VacationAdapterContract.Model
    override var adapterView: VacationAdapterContract.View? = null
        set(value) {//커스텀 접근자
            field = value
            field?.onClickFunc = { onClickListener(it)}
        }

    override fun callItems(firstDate: Date, lastDate: Date, isclear: Boolean) {
        val email: String = "이메일"
        if (isclear) {
            adapterModel.clearItems()
        }
        vacationModel.callVacations(context, firstDate, lastDate, email, this)
    }

    override fun onSuccess(context: Context, result: ArrayList<VacationItem>) {
        adapterModel.addItems(result)
        adapterView?.notifyAdapter()
        view.progressInvisible()
    }

    override fun onFailure() {
        view.progressInvisible()
    }

    override fun cancelAsyncTask() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onClickListener(position:Int)
    {
        adapterModel.getItem(position).let {
            it.idx?.let { it1 -> view.detailVacation(it1) }
        }
    }
}