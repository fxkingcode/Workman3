package com.example.workman.View.Detail_Group

import android.content.Context
import android.content.Intent
import com.example.workman.Model.DAO.EmployeeModel
import com.example.workman.Model.DAO.GroupModel
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.R
import com.example.workman.View.Detail_Employee.DetailEmployeeContract

class DetailGroupPresenter(
    private val context: Context,
    val view: DetailGroupContract.IDetailGroupView
) : DetailGroupContract.IDetailGroupPresenter, DetailGroupContract.Listener {
    private var idx: Int? = null
    private var groupDto:GroupDto? = null

    private var employeeModel: EmployeeModel =
        EmployeeModel(context)
    private var groupModel: GroupModel = GroupModel()

    override fun getIntent(intent: Intent) {
        this.idx = intent.getIntExtra("idx", -1)
    }

    override fun callGroup() {
        idx?.let { groupModel.callGroup(context, "company", it, this) }
    }

    override fun modifyClick() {
        groupDto?.let { view.modifyGroup(it) }
    }

    override fun onEmployeeFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(group: GroupDto) {
        groupDto = group

        group.name?.let { view.setNameText(it) }
        when (val markerText = group.marker) {
            "검정색" -> {
                view.setMarkerText(markerText)
                view.setMarkerBackground(R.color.black)
            }
            "파란색" -> {
                view.setMarkerText(markerText)
                view.setMarkerBackground(R.color.blue)
            }
            "빨간색" -> {
                view.setMarkerText(markerText)
                view.setMarkerBackground(R.color.red)
            }
            "초록색" -> {
                view.setMarkerText(markerText)
                view.setMarkerBackground(R.color.green)
            }
            "회색" -> {
                view.setMarkerText(markerText)
                view.setMarkerBackground(R.color.gray)
            }
            "민트색" -> {
                view.setMarkerText(markerText)
                view.setMarkerBackground(R.color.mint)
            }
        }

        group.memo?.let { view.setMemoText(it) }
        view.setPersonnelText(group.employees?.size.toString())
        if (group.employees?.size != 0) {
            group.employees?.let {
                for (i in it.indices) {
                    employeeModel.callEmployee(it[i], this)
                }
            }
        } else {
            view.setEmployeesText("해당 그룹에 속한 직원 없음")
        }
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEmployeeSuccess(employeeDto: EmployeeDto) {
        employeeDto.name?.let { view.setEmployeesText(it) }
    }
}