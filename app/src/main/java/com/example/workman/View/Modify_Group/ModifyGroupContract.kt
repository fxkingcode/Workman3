package com.example.workman.View.Modify_Group

import android.content.Intent
import com.example.workman.Model.DTO.SelectGroupData

interface ModifyGroupContract {
    interface IModifyGroupPresenter {
        fun deleteGroup()
        fun modifySave()
        fun getIntent(intent: Intent)
        fun nameChange(text: String)
    }

    interface IModifyGroupView {
        fun activeSave(boolean: Boolean)
        fun saveAlpha(float: Float)
        fun setNameText(text: String)
        fun setMarker(colorId:Int,colorText: String)
        fun setMemoText(text: String)
        fun finishActivity()
        fun progressVisible(boolean: Boolean)
        fun toastMessage(text: String)
    }

    interface Listener {
        fun onSuccess()
        fun onFailure()
    }
}