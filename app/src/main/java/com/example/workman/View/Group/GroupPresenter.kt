package com.example.workman.View.Group

import android.content.Context
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DAO.EmployeeModel
import com.example.workman.Model.DAO.GroupModel
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.R
import com.example.workman.View.Employee.EmployeeContract
import java.util.ArrayList

class GroupPresenter(
    private val context: Context,
    val view: GroupContract.IGroupView
) : GroupContract.IGroupPresenter, GroupContract.Listener {
    private var groupModel: GroupModel =
        GroupModel()

    override var adapterModel: GroupAdapterContract.Model? = null
    override var adapterView: GroupAdapterContract.View? = null
        set(value) {
            field = value
            field?.onClickFunc = { onClickListener(it) }
        }

    override fun fabClick() {
        view.addGroup()
    }

    override fun callGroups() {
        groupModel.callGroups(context,"company",this)
    }

    override fun onSuccess(context: Context, result: ArrayList<GroupDto>) {
        adapterModel?.clearItems()
        adapterModel?.addItems(result)
        adapterView?.notifyAdapter()
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onClickListener(position: Int) {
        adapterModel?.getItem(position).let {
            it?.idx?.let { it1 -> view.detailGroup(it1) }
        }
    }
}