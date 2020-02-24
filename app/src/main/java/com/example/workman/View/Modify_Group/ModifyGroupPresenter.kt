package com.example.workman.View.Modify_Group

import android.content.Context
import android.content.Intent
import com.example.workman.Model.DAO.GroupModel
import com.example.workman.R
import com.example.workman.View.Modify_Employee.ModifyEmployeeContract

class ModifyGroupPresenter(
    private val context: Context,
    val view: ModifyGroupContract.IModifyGroupView
) : ModifyGroupContract.IModifyGroupPresenter, ModifyGroupContract.Listener {
    private var idx: Int? = null
    private val groupModel:GroupModel = GroupModel()

    override fun getIntent(intent: Intent) {
        if(intent.hasExtra("idx"))
        {
            idx = intent.getIntExtra("idx",-1)
        }
        if(intent.hasExtra("marker"))
        {
            when(val colorText = intent.getStringExtra("marker"))
            {
                "검정색" -> {
                    view.setMarker(R.color.black,colorText)
                }
                "파란색" -> {
                    view.setMarker(R.color.blue,colorText)
                }
                "빨간색" -> {
                    view.setMarker(R.color.red,colorText)
                }
                "초록색" -> {
                    view.setMarker(R.color.green,colorText)
                }
                "회색" -> {
                    view.setMarker(R.color.gray,colorText)
                }
                "민트색" -> {
                    view.setMarker(R.color.mint,colorText)
                }
            }
        }
        if(intent.hasExtra("name"))
        {
            view.setNameText(intent.getStringExtra("name"))
        }
        if(intent.hasExtra("memo"))
        {
            view.setMemoText(intent.getStringExtra("memo"))
        }
    }

    override fun modifySave() {
        groupModel.modifyGroup()
    }

    override fun deleteGroup() {

    }

    override fun nameChange(text: String) {
        if (text.isEmpty()) {
            view.saveAlpha(0.4f)
            view.activeSave(false)
        } else {
            view.saveAlpha(1.0f)
            view.activeSave(true)
        }
    }

    override fun onSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}