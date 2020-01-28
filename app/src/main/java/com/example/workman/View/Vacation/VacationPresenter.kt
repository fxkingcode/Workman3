package com.example.workman.View.Vacation

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Data.VacationItem
import com.example.workman.Model.VacationModel
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class VacationPresenter(
    private val context: Context,
    val view: VacationContract.IVacationView
) : VacationContract.IVacationPresenter, VacationContract.Listener {

    private var vacationModel: VacationModel = VacationModel()
    override lateinit var adapterModel: VacationAdapterContract.Model
    override lateinit var adapterView: VacationAdapterContract.View

    override fun callItems(firstDate: Date, lastDate: Date, isclear:Boolean) {
        val email: String = "이메일"
        if(isclear)
        {
            adapterModel.clearItems()
        }
        vacationModel.callItems(context, firstDate, lastDate, email, this)
    }

    override fun onSuccess(context: Context, result: ArrayList<VacationItem>) {
        adapterModel.addItems(result)
        adapterView.notifyAdapter()
        view.progressInvisible()
    }

    override fun onFailure() {
        view.progressInvisible()
    }

    override fun cancelAsyncTask() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}