package com.example.workman.View.Add_Group

import android.content.Context
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DTO.GroupDto
import java.util.ArrayList

interface AddGroupContract {
    interface IAddGroupPresenter{
        fun nameChange(text: String)
        fun createClick()
    }

    interface IAddGroupView{
        fun createButtonAlpha(float: Float)
        fun createButtonEnable(boolean: Boolean)
        fun progressVisible(boolean: Boolean)
        fun finishActivity()
        fun toastMessage(text:String)
    }

    interface Listener
    {
        fun onSuccess(context: Context, result: ArrayList<GroupDto>)
        fun onFailure()
    }
}