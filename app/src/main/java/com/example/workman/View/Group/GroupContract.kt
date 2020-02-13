package com.example.workman.View.Group

import android.content.Context
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DTO.GroupDto
import java.util.ArrayList

interface GroupContract {
    interface IGroupPresenter{
        var adapterModel: GroupAdapterContract.Model?
        var adapterView: GroupAdapterContract.View?
        fun fabClick()
        fun callGroups()
    }

    interface IGroupView{
        fun detailGroup(idx:Int)
        fun addGroup()
        fun progressVisible(boolean: Boolean)
        fun finishActivity()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess(context: Context,result: ArrayList<GroupDto>)
        fun onFailure()
    }
}