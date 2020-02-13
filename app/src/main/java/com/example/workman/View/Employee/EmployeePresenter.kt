package com.example.workman.View.Employee

import android.content.Context
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Model.DAO.EmployeeModel
import com.example.workman.Model.DAO.VacationModel
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.R
import com.example.workman.View.Manager_Vacation.ManagerVacationContract
import java.util.*

class EmployeePresenter(
    private val context: Context,
    val view: EmployeeContract.IEmployeeView
) : EmployeeContract.IEmployeePresenter, EmployeeContract.Listener {

    private var employeeModel: EmployeeModel =
        EmployeeModel()

    override var adapterActiveModel: EmployeeAdapterContract.Model? = null
    override var adapterActiveView: EmployeeAdapterContract.View? = null
        set(value) {//커스텀 접근자
            field = value
            field?.onClickFunc = { onActiveClickListener(it) }
        }

    override var adapterPassiveModel: EmployeeAdapterContract.Model? = null
    override var adapterPassiveView: EmployeeAdapterContract.View? = null
        set(value) {//커스텀 접근자
            field = value
            field?.onClickFunc = { onPassiveClickListener(it) }
        }

    override fun activeEmployee() {
        view.changeActiveAdapter()
        view.setActiveBackground(R.drawable.bottomline)
        view.setPassiveBackground(null)
        view.activeButtonEnable(false)
        view.passiveButtonEnable(true)
        callItems(true)
    }

    override fun passiveEmployee() {
        view.changePassiveAdapter()
        view.setPassiveBackground(R.drawable.bottomline)
        view.setActiveBackground(null)
        view.passiveButtonEnable(false)
        view.activeButtonEnable(true)
        callItems(false)
    }

    private fun onActiveClickListener(position: Int) {
        adapterActiveModel?.getItem(position).let {
            it?.idx?.let { it1 -> view.detailEmployee(it1) }
        }
    }

    private fun onPassiveClickListener(position: Int) {
        adapterPassiveModel?.getItem(position).let {
            it?.idx?.let { it1 -> view.detailEmployee(it1) }
        }
    }

    override fun callItems(isActive:Boolean) {
        employeeModel.callEmployees(context,"companyid",this,isActive)
    }

    override fun onActiveSuccess(context: Context, result: ArrayList<EmployeeDto>) {
        adapterActiveModel?.clearItems()
        adapterActiveModel?.addItems(result)
        adapterActiveView?.notifyAdapter()
    }

    override fun onPassiveSuccess(context: Context, result: ArrayList<EmployeeDto>) {
        adapterPassiveModel?.clearItems()
        adapterPassiveModel?.addItems(result)
        adapterPassiveView?.notifyAdapter()
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}