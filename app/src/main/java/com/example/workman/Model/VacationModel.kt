package com.example.workman.Model

import android.content.Context
import com.example.workman.Data.VacationItem
import com.example.workman.View.Request_Vacation.ReqvacationContract
import com.example.workman.View.Vacation.VacationContract
import com.prolificinteractive.materialcalendarview.CalendarDay
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class VacationModel {
    fun callItems(
        context: Context,
        firstDate: Date,
        lastDate: Date,
        email: String,
        listener: VacationContract.Listener
    ) {
        val params = HashMap<String,String>()
        params["FirstDate"] = firstDate.toString()
        params["LastDate"] = lastDate.toString()
        params["Email"] = email

        //api통신 여기서

        val items = ArrayList<VacationItem>()
        items.add(VacationItem(1, "연차", Date(System.currentTimeMillis()), false, null, null,null,email))
        items.add(VacationItem(1, "연차", Date(System.currentTimeMillis()), true, null, null,null,email))
        items.add(VacationItem(1, "연차", Date(System.currentTimeMillis()), false, null, null,null,email))

        listener.onSuccess(context, items)
    }

    fun vacationRequest(date:Date, type: String, startTime:String?, endTime:String?, reason:String?,listener:ReqvacationContract.Listener)
    {
        val email:String = "이메일"
        val vacationItem:VacationItem = VacationItem(null,type,date,false,startTime,endTime,reason,email)
        val map = HashMap<String,VacationItem>()
        map["vacation"] = vacationItem

        //api통신 여기서

        listener.onSuccess()
    }
}