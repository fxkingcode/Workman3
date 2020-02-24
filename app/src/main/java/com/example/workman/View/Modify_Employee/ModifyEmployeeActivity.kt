package com.example.workman.View.Modify_Employee

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
import kotlinx.android.synthetic.main.activity_modify_employee.*

class ModifyEmployeeActivity : AppCompatActivity(), ModifyEmployeeContract.IModifyEmployeeView,
    View.OnClickListener {

    private var presenter: ModifyEmployeePresenter? = null
    private var groupArray: ArrayList<SelectGroupData>? = null
    private val SELECTGROUP: Int = 1
    private var positionAdapter: ArrayAdapter<CharSequence>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_employee)

        initialize()
        presenter?.getIntent(intent)
    }

    private fun initialize() {
        presenter = ModifyEmployeePresenter(this, this)
        positionAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.position,
            android.R.layout.simple_dropdown_item_1line
        )
        ME_position.adapter = positionAdapter
        groupArray = ArrayList()

        ME_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter?.nameChange(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        ME_active.setOnClickListener(this)
        ME_inactive.setOnClickListener(this)
        ME_save.setOnClickListener(this)
        ME_group.setOnClickListener(this)
    }

    override fun setInactiveButtonVisible(boolean: Boolean) {
        if (boolean) {
            ME_inactive.visibility = View.VISIBLE
        } else {
            ME_inactive.visibility = View.INVISIBLE
        }
    }

    override fun setActiveButtonVisible(boolean: Boolean) {
        if (boolean) {
            ME_active.visibility = View.VISIBLE
        } else {
            ME_active.visibility = View.INVISIBLE
        }
    }

    override fun setNameText(text: String) {
        ME_name.setText(text)
    }

    override fun setPositionText(text: String) {
        positionAdapter?.getPosition(text)?.let { ME_position.setSelection(it) }
    }

    override fun setEmailText(text: String) {
        ME_email.setText(text)
    }

    override fun setPhoneText(text: String) {
        ME_phone.setText(text)
    }

    override fun setMemoText(text: String) {
        ME_memo.setText(text)
    }

    override fun checkAlpha(float: Float) {
        ME_nameCheck.alpha = float
    }

    override fun activeSave(boolean: Boolean) {
        ME_save.isEnabled = boolean
    }

    override fun saveAlpha(float: Float) {
        ME_save.alpha = float
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
        ME_group.text = text
    }

    override fun addGroupArray(arrayList: ArrayList<SelectGroupData>) {
        groupArray = arrayList
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ME_save -> {
                presenter?.modifySave()
            }
            R.id.ME_group -> {
                presenter?.groupClick()
            }
            R.id.ME_active -> {
                presenter?.activeChange(true)
            }
            R.id.ME_inactive -> {
                presenter?.activeChange(false)
            }
        }
    }

    override fun finishActivity() {
        finish()
    }

    override fun progressVisible(boolean: Boolean) {
        if (boolean) {
            ME_progressBar.visibility = View.VISIBLE
        } else {
            ME_progressBar.visibility = View.INVISIBLE
        }
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
