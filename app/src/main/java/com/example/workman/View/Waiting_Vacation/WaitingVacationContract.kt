package com.example.workman.View.Waiting_Vacation

import android.content.Context
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DTO.VacationItem
import java.util.*

interface WaitingVacationContract {
    interface IWaitingVacationPresenter{
        var adapterModel: VacationAdapterContract.Model?
        var adapterView: VacationAdapterContract.View?
        fun callItems(firstDate: Date, lastDate: Date, isclear:Boolean)
    }

    interface IWaitingVacationView{
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
        fun detailVacation(idx:Int)
    }

    interface Listener
    {
        fun onSuccess(context: Context, result: ArrayList<VacationItem>)
        fun onFailure()
    }
}