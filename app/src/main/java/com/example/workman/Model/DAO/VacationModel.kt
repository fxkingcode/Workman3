package com.example.workman.Model.DAO

import android.content.Context
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.View.Detail_Vacation.DetailvacaContract
import com.example.workman.View.Employee_Vacation.EmployeeVacationContract
import com.example.workman.View.My_Vacation.MyVacationContract
import com.example.workman.View.Request_Vacation.ReqvacationContract
import com.example.workman.View.Vacation.VacationContract
import com.example.workman.View.Waiting_Vacation.WaitingVacationContract
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
    ) {//오버로딩
        val params = HashMap<String, String>()
        params["FirstDate"] = firstDate.toString()
        params["LastDate"] = lastDate.toString()
        params["Email"] = email

        //api통신 여기서. myvacation url

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

    fun callVacations(
        context: Context,
        firstDate: Date,
        lastDate: Date,
        email: String,
        listener: EmployeeVacationContract.Listener
    ) {//오버로딩
        val params = HashMap<String, String>()
        params["FirstDate"] = firstDate.toString()
        params["LastDate"] = lastDate.toString()
        params["Email"] = email

        //api통신 여기서. employeevacation url

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

    fun callVacations(
        context: Context,
        firstDate: Date,
        lastDate: Date,
        email: String,
        listener: MyVacationContract.Listener
    ) {//오버로딩
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

    fun callVacations(
        context: Context,
        email: String,
        listener: WaitingVacationContract.Listener
    ) {//오버로딩
        val params = HashMap<String, String>()
        params["Email"] = email

        //api통신 여기서. waitingvacation url

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

    fun cancelVacation(idx: Int, listener: DetailvacaContract.Listener) {
        val params = HashMap<String, Int>()
        params["idx"] = idx

        //api통신 여기서

        listener.cancelVacationSuccess()
    }

    fun callVacation(idx: Int, listener: DetailvacaContract.Listener) {
        val params = HashMap<String, Int>()
        params["idx"] = idx

        //api통신 여기서
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