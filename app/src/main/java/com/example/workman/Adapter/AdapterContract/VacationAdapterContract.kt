package com.example.workman.Adapter.AdapterContract

import com.example.workman.Data.VacationItem

interface VacationAdapterContract {
    interface View {
        fun notifyAdapter()
    }

    interface Model {
        fun addItems(vacationItems:ArrayList<VacationItem>)
        fun clearItems()
    }
}