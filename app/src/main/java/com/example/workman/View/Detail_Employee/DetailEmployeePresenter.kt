package com.example.workman.View.Detail_Employee

import android.content.Context
import com.example.workman.Model.DAO.EmployeeModel
import com.example.workman.Model.DAO.GroupModel
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData

class DetailEmployeePresenter(
    private val context: Context,
    val view: DetailEmployeeContract.IDetailEmployeeView
) : DetailEmployeeContract.IDetailEmployeePresenter, DetailEmployeeContract.Listener {

    private var employee: EmployeeDto? = null
    private var groupCheckArray: ArrayList<SelectGroupData> = ArrayList()

    private var employeeModel: EmployeeModel =
        EmployeeModel(context)
    private var groupModel: GroupModel = GroupModel()

    override fun callEmployee(idx: Int) {
        employeeModel.callEmployee(idx, this)
    }

    override fun modifyClick() {
        employee?.let { view.modifyEmployee(it,groupCheckArray) }
    }

    override fun onSuccess(employee: EmployeeDto) {
        this.employee = employee

        view.setNameText(employee.name.toString())
        view.setPositionText(employee.position.toString())
        view.setEmailText(employee.email.toString())
        view.setPhoneText(employee.phone.toString())
        if (employee.state!!) {
            view.setStateText("합류")
        } else {
            view.setStateText("미합류")
        }
        view.setMemoText(employee.memo.toString())

        val array: ArrayList<String>? = employee.group
        array?.let {
            for (i in array.indices) {
                groupModel.callGroup(context, "company", array[i], this)
            }
        }

        if(array == null || array.size == 0)
        {
            view.setGroupText("없음")
        }
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGroupSuccess(group: GroupDto) {
        val selectGroup = group.name?.let { group.id?.let { it1 -> SelectGroupData(it1, it) } }
        selectGroup?.let { groupCheckArray.add(it) }

        if (view.getGroupText() == "") {
            group.name?.let { view.setGroupText(it) }

        } else {
            group.name?.let { view.setGroupText(view.getGroupText() + " , " + it) }
        }
    }

    override fun onGroupFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}