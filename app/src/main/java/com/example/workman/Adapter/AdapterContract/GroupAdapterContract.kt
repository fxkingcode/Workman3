package com.example.workman.Adapter.AdapterContract

import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData

interface GroupAdapterContract {
    interface View {
        var onClickFunc : ((Int) -> Unit)?//1급객체
        fun notifyAdapter()
        fun allCheck(boolean: Boolean)
        fun filter(text:String)
    }

    interface Model {
        fun addItems(groupItems:ArrayList<GroupDto>)
        fun clearItems()
        fun getItem(position:Int): GroupDto
        fun getCheckArray():ArrayList<SelectGroupData>
        fun setCheckArray(array: ArrayList<SelectGroupData>)
    }
}