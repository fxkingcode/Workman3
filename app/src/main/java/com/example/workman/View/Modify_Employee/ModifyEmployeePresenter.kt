package com.example.workman.View.Modify_Employee

import android.content.Context
import android.content.Intent
import com.example.workman.Model.DTO.SelectGroupData

class ModifyEmployeePresenter(
    private val context: Context,
    val view: ModifyEmployeeContract.IModifyEmployeeView
) : ModifyEmployeeContract.IModifyEmployeePresenter, ModifyEmployeeContract.Listener {
    private var idx: Int? = null

    override fun getIntent(intent: Intent) {
        if (intent.hasExtra("email")) {
            view.setEmailText(intent.getStringExtra("email"))
        }
        if (intent.hasExtra("phone")) {
            view.setPhoneText(intent.getStringExtra("phone"))
        }
        if (intent.hasExtra("name")) {
            view.setNameText(intent.getStringExtra("name"))
        }
        if (intent.hasExtra("position")) {
            view.setPositionText(intent.getStringExtra("position"))
        }
        if (intent.hasExtra("memo")) {
            view.setMemoText(intent.getStringExtra("memo"))
        }
        if (intent.hasExtra("isActive")) {
            view.setInactiveButtonVisible(intent.getBooleanExtra("isActive", false))
        }
        idx = intent.getIntExtra("idx", -1)

        if (intent.hasExtra("group")) {
            val array: ArrayList<SelectGroupData>? =
                intent.getSerializableExtra("group") as ArrayList<SelectGroupData>
            array?.let {
                view.addGroupArray(it)
                when {
                    array.size == 0 -> view.setGroupButtonText("선택 안함")
                    array.size == 1 -> view.setGroupButtonText(array[0].name)
                    else -> view.setGroupButtonText("${array.size}개 선택")
                }
            }
        }
    }

    override fun nameChange(text: String) {
        if (text.isEmpty()) {
            view.checkAlpha(0.4f)
            view.saveAlpha(0.4f)
            view.activeSave(false)
        } else {
            view.checkAlpha(1.0f)
            view.saveAlpha(1.0f)
            view.activeSave(true)
        }
    }

    override fun groupClickResult(data: Intent?) {
        var arrayList: ArrayList<SelectGroupData> =
            data?.getSerializableExtra("GroupCheck") as ArrayList<SelectGroupData>
        val hs:HashSet<SelectGroupData> = HashSet(arrayList) // 중복 제거
        arrayList = ArrayList(hs)
        view.addGroupArray(arrayList)

        when {
            arrayList.size == 0 -> view.setGroupButtonText("선택 안함")
            arrayList.size == 1 -> view.setGroupButtonText(arrayList[0].name)
            else -> view.setGroupButtonText("${arrayList.size}개 선택")
        }
    }

    override fun groupClick() {
        view.selectGroup()
    }

    override fun onSuccess() {

    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}