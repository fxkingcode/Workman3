package com.example.workman.View.Vacation

import android.content.Context
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DTO.VacationItem
import java.util.*
import kotlin.collections.ArrayList

interface VacationContract {
    interface IVacationPresenter{
        fun callItems(firstDate: Date,lastDate:Date,isclear:Boolean)
        fun cancelAsyncTask()
        var adapterModel:VacationAdapterContract.Model
        var adapterView:VacationAdapterContract.View?
    }

    interface IVacationView{
        fun finishActivity()
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
        fun detailVacation(idx:Int)
    }

    interface Listener
    {
        fun onSuccess(context: Context, result:ArrayList<VacationItem>)
        fun onFailure()
    }
}