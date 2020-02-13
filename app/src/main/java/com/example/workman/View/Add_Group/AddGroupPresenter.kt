package com.example.workman.View.Add_Group

import android.content.Context
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.View.Add_Employee.AddEmployeeContract
import java.util.ArrayList

class AddGroupPresenter(
    private val context: Context,
    val view: AddGroupContract.IAddGroupView
) : AddGroupContract.IAddGroupPresenter, AddGroupContract.Listener {
    override fun nameChange(text: String) {
        if(text.isEmpty())
        {
            view.createButtonAlpha(0.4f)
            view.createButtonEnable(false)
        }else
        {
            view.createButtonAlpha(1.0f)
            view.createButtonEnable(true)
        }
    }

    override fun createClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(context: Context, result: ArrayList<GroupDto>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}