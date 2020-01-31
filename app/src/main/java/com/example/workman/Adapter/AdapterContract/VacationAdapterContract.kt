package com.example.workman.Adapter.AdapterContract

import com.example.workman.Model.DTO.VacationItem

interface VacationAdapterContract {
    interface View {
        var onClickFunc : ((Int) -> Unit)?//1급객체
        fun notifyAdapter()
    }

    interface Model {
        fun addItems(vacationItems:ArrayList<VacationItem>)
        fun clearItems()
        fun getItem(position:Int):VacationItem
    }
}