package com.example.workman.View.Add_Employee

import android.content.Context
import android.content.Intent
import com.example.workman.Model.DAO.EmployeeModel
import com.example.workman.Model.DTO.SelectGroupData
import com.example.workman.R
import com.example.workman.View.Employee.EmployeeContract

class AddEmployeePresenter(
    private val context: Context,
    val view: AddEmployeeContract.IAddEmployeeView
) : AddEmployeeContract.IAddEmployeePresenter, AddEmployeeContract.Listener {

    private var employeeModel: EmployeeModel =
        EmployeeModel(context)

    override fun nameChange(text: String) {
        if(text.isEmpty())
        {
            view.checkAlpha(0.4f)
            view.createAlpha(0.4f)
            view.activeCreate(false)
        }else
        {
            view.checkAlpha(1.0f)
            view.createAlpha(1.0f)
            view.activeCreate(true)
        }
    }
    override fun groupClickResult(data: Intent?) {
        var arrayList: ArrayList<SelectGroupData> =
            data?.getSerializableExtra("GroupCheck") as ArrayList<SelectGroupData>
        val hs:HashSet<SelectGroupData> = HashSet(arrayList)
        arrayList = ArrayList(hs)
        view.addGroupArray(arrayList)
        when {
            arrayList.size == 0 -> view.setGroupButtonText("선택 안함")
            arrayList.size == 1 -> view.setGroupButtonText(arrayList[0].name)
            else -> view.setGroupButtonText("${arrayList.size}개 선택")
        }
    }

    override fun create(
        name: String,
        position: String,
        group: ArrayList<SelectGroupData>?,
        email: String?,
        phoneNum: String?,
        invite: Boolean,
        memo: String?
    ) {
        val hashMap = HashMap<String,Any>()
        hashMap["name"] = name
        hashMap["position"] = position
        group?.let { hashMap.put("group", it) }
        email?.let { hashMap.put("email", it) }
        phoneNum?.let { hashMap.put("phone", it) }
        hashMap["invite"] = invite
        memo?.let { hashMap.put("memo", it) }

        employeeModel.createEmployee(hashMap,this)
        view.progressVisible()
    }

    override fun groupClick() {
        view.selectGroup()
    }

    override fun onSuccess() {
        view.progressInvisible()
        view.toastMessage("직원이 생성되었습니다.")
        view.finishActivity()
    }

    override fun onFailure() {
        view.progressInvisible()
        view.toastMessage("생성 실패 오류")
    }
}