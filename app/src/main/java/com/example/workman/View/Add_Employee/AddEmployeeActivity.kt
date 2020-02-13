package com.example.workman.View.Add_Employee

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.workman.Model.DTO.SelectGroupData
import com.example.workman.R
import com.example.workman.View.Select_Group.SelectGroupActivity
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_reqvacation.*

class AddEmployeeActivity : AppCompatActivity(), AddEmployeeContract.IAddEmployeeView,
    View.OnClickListener {
    private var presenter: AddEmployeePresenter? = null
    private var groupArray: ArrayList<SelectGroupData>? = null
    private val SELECTGROUP: Int = 1
    private var positionAdapter: ArrayAdapter<CharSequence>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

        initialize()
    }

    private fun initialize() {
        presenter = AddEmployeePresenter(this, this)
        positionAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.position,
            android.R.layout.simple_dropdown_item_1line
        )
        AE_position.adapter = positionAdapter
        groupArray = ArrayList()
        AE_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter?.nameChange(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        AE_group.setOnClickListener(this)
        AE_create.setOnClickListener(this)
    }

    override fun checkAlpha(float: Float) {
        AE_nameCheck.alpha = float
    }

    override fun activeCreate(boolean: Boolean) {
        AE_create.isEnabled = boolean
    }

    override fun createAlpha(float: Float) {
        AE_create.alpha = float
    }

    override fun finishActivity() {
        finish()
    }

    override fun progressVisible() {
        RV_progressBar.visibility = View.VISIBLE
    }

    override fun progressInvisible() {
        RV_progressBar.visibility = View.INVISIBLE
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun selectGroup() {
        startActivityForResult(
            Intent(this, SelectGroupActivity::class.java).putExtra(
                "groupArray",
                groupArray
            ), SELECTGROUP
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                SELECTGROUP -> {
                    presenter?.groupClickResult(data)
                }
            }
        }
    }

    override fun setGroupButtonText(text: String) {
        AE_group.text = text
    }

    override fun addGroupArray(arrayList: ArrayList<SelectGroupData>) {
        groupArray = arrayList
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.AE_group -> {
                presenter?.groupClick()
            }
            R.id.AE_create -> {
                presenter?.create(
                    AE_name.toString(),
                    AE_position.selectedItem.toString(),
                    groupArray,
                    AE_email.toString(),
                    AE_phone.toString(),
                    AE_invite.isChecked,
                    AE_memo.toString()
                )
            }
        }
    }
}
