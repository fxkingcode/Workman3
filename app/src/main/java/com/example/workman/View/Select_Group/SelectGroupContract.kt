package com.example.workman.View.Select_Group

import android.content.Context
import android.content.Intent
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData
import java.util.ArrayList

interface SelectGroupContract {
    interface ISelectGroupPresenter{
        var adapterModel: GroupAdapterContract.Model?
        var adapterView: GroupAdapterContract.View?
        fun getIntent(intent:Intent?)
        fun complete()
        fun callGroups()
        fun allSelectClick(boolean: Boolean)
        fun filter(text:String)
    }

    interface ISelectGroupView{
        fun finishActivity(arrayList: ArrayList<SelectGroupData>)
        fun progressVisible()
        fun progressInvisible()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess(context: Context, result: ArrayList<GroupDto>)
        fun onFailure()
    }
}