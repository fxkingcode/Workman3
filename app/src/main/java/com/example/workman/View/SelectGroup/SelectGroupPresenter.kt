package com.example.workman.View.SelectGroup

import android.content.Context
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DAO.EmployeeModel
import com.example.workman.Model.DAO.GroupModel
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.View.Employee.EmployeeContract
import java.util.ArrayList

class SelectGroupPresenter(
    private val context: Context,
    val view: SelectGroupContract.ISelectGroupView
) : SelectGroupContract.ISelectGroupPresenter, SelectGroupContract.Listener {

    private var groupModel: GroupModel =
        GroupModel()

    override var adapterModel: GroupAdapterContract.Model? = null
    override var adapterView: GroupAdapterContract.View? = null

    override fun complete() {
        adapterModel?.getCheckArray()?.let { view.finishActivity(it) }
    }

    override fun allSelectClick(boolean: Boolean) {
        adapterView?.allCheck(boolean)
        adapterView?.notifyAdapter()
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
}