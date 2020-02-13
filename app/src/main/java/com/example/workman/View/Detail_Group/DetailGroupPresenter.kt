package com.example.workman.View.Detail_Group

import android.content.Context
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.View.Detail_Employee.DetailEmployeeContract

class DetailGroupPresenter(
    private val context: Context,
    val view: DetailGroupContract.IDetailGroupView
) : DetailGroupContract.IDetailGroupPresenter, DetailGroupContract.Listener {
    override fun callGroup(idx: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun modifyClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(employee: EmployeeDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEmployeeSuccess(group: GroupDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEmployeeFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}