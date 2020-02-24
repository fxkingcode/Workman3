package com.example.workman.View.Detail_Employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.SelectGroupData
import com.example.workman.R
import com.example.workman.View.Modify_Employee.ModifyEmployeeActivity
import kotlinx.android.synthetic.main.activity_detail_employee.*
import kotlin.collections.ArrayList

class DetailEmployeeActivity : AppCompatActivity(),DetailEmployeeContract.IDetailEmployeeView,
    View.OnClickListener {

    private var idx: Int? = null
    private var presenter:DetailEmployeePresenter? = null
    private var MODIFYEMPLOYEE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_employee)

        initialize()
        idx?.let { presenter?.callEmployee(it) }
    }

    private fun initialize()
    {
        presenter = DetailEmployeePresenter(this, this)
        idx = intent.getIntExtra("idx", -1)

        DE_modify.setOnClickListener(this)
    }

    override fun setNameText(text: String)
    {
        DE_name.text = text
    }

    override fun setPositionText(text: String)
    {
        DE_position.text = text
    }

    override fun setGroupText(text: String)
    {
        DE_group.text = text
    }

    override fun getGroupText():String
    {
        return DE_group.text.toString()
    }

    override fun setEmailText(text: String)
    {
        DE_email.text = text
    }

    override fun setPhoneText(text: String)
    {
        DE_phone.text = text
    }

    override fun setMemoText(text: String)
    {
        DE_memo.text = text
    }

    override fun setStateText(text: String)
    {
        DE_state.text = text
    }

    override fun finishActivity() {
        finish()
    }

    override fun progressVisible() {
        DE_progressBar.visibility = View.VISIBLE
    }

    override fun progressInvisible() {
        DE_progressBar.visibility = View.INVISIBLE
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun modifyEmployee(employee:EmployeeDto,groupCheckArray:ArrayList<SelectGroupData>)
    {
        var intent = Intent(this, ModifyEmployeeActivity::class.java)
        intent.putExtra("idx",employee.id)
        intent.putExtra("email",employee.email)
        intent.putExtra("phone",employee.phone)
        intent.putExtra("name",employee.name)
        intent.putExtra("position",employee.position)
        intent.putExtra("group",groupCheckArray)
        intent.putExtra("isActive",employee.isActive)
        intent.putExtra("memo",employee.memo)
        intent.putExtra("state",employee.state)
        startActivityForResult(intent,MODIFYEMPLOYEE)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.DE_modify -> {
                presenter?.modifyClick()
            }
        }
    }
}
