package com.example.workman.View.Select_Group

import android.content.Context
import android.content.Intent
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Model.DAO.GroupModel
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData
import java.util.ArrayList

class SelectGroupPresenter(
    private val context: Context,
    val view: SelectGroupContract.ISelectGroupView
) : SelectGroupContract.ISelectGroupPresenter, SelectGroupContract.Listener {

    private var groupModel: GroupModel =
        GroupModel()

    override var adapterModel: GroupAdapterContract.Model? = null
    override var adapterView: GroupAdapterContract.View? = null

    override fun getIntent(intent: Intent?) {
        val groupArray = intent?.getSerializableExtra("groupArray") as ArrayList<SelectGroupData>
        adapterModel?.setCheckArray(groupArray)
    }

    override fun complete() {
        adapterModel?.getCheckArray()?.let { view.finishActivity(it) }
    }

    override fun filter(text:String)
    {
        adapterView?.filter(text)
    }

    override fun allSelectClick(boolean: Boolean) {
        adapterView?.allCheck(boolean)
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