package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.Model.User
import com.example.workman.View.Detail_Vacation.DetailvacaContract
import com.example.workman.View.Request_Vacation.ReqvacationContract
import com.example.workman.View.Vacation.VacationContract
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class VacationModel {
    fun callVacations(
        context: Context,
        firstDate: Date,
        lastDate: Date,
        email: String,
        listener: VacationContract.Listener
    ) {
        val params = HashMap<String, String>()
        params["FirstDate"] = firstDate.toString()
        params["LastDate"] = lastDate.toString()
        params["Email"] = email

        //api통신 여기서

        val items = ArrayList<VacationItem>()
        items.add(
            VacationItem(
                1,
                "이름",
                "연차",
                Date(System.currentTimeMillis()),
                null,
                null,
                null,
                null,
                null,
                null,
                email
            )
        )
        items.add(
            VacationItem(
                1,
                "이름",
                "연차",
                Date(System.currentTimeMillis()),
                true,
                null,
                null,
                null,
                null,
                null,
                email
            )
        )
        items.add(
            VacationItem(
                1,
                "이름",
                "연차",
                Date(System.currentTimeMillis()),
                false,
                null,
                null,
                null,
                null,
                null,
                email
            )
        )

        listener.onSuccess(context, items)
    }

    fun cancelVacation(idx:Int,listener: DetailvacaContract.Listener)
    {
        val params = HashMap<String, Int>()
        params["idx"] = idx

        //api통신 여기서

        listener.cancelVacationSuccess()
    }

    fun callVacation(idx: Int, listener: DetailvacaContract.Listener) {
        val params = HashMap<String, Int>()
        params["idx"] = idx

        //api통신 여기서
        VacationItem( //idx로 vacation을 찾은 후 vacation에 저장된 email로 employee를 찾고 두 데이터를 가져온다
            1,
            "이름",
            "연차",
            Date(System.currentTimeMillis()),
            null,
            null,
            null,
            null,
            null,
            null,
            "email"
        ).let {
            listener.callVacationSuccess(it)
        }
    }

    fun vacationRequest(vacationItem: VacationItem, listener: ReqvacationContract.Listener) {
        val map = HashMap<String, VacationItem>()
        map["Vacation"] = vacationItem

        //api통신 여기서

        listener.onSuccess()
    }
}