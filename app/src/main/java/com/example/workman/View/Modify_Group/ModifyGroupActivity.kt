package com.example.workman.View.Modify_Group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.workman.Adapter.SpinnerAdapter
import com.example.workman.Model.DTO.ColorData
import com.example.workman.R
import kotlinx.android.synthetic.main.activity_add_group.*
import kotlinx.android.synthetic.main.activity_modify_employee.*
import kotlinx.android.synthetic.main.activity_modify_group.*

class ModifyGroupActivity : AppCompatActivity(), ModifyGroupContract.IModifyGroupView,
    View.OnClickListener {

    private var presenter: ModifyGroupPresenter? = null
    private var spinnerAdapter: SpinnerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_group)

        initialize()
        presenter?.getIntent(intent)
    }

    private fun initialize() {
        presenter = ModifyGroupPresenter(this, this)

        val list: ArrayList<ColorData> = ArrayList()
        list.add(ColorData(R.color.black, "검정색"))
        list.add(ColorData(R.color.blue, "파란색"))
        list.add(ColorData(R.color.red, "빨간색"))
        list.add(ColorData(R.color.green, "초록색"))
        list.add(ColorData(R.color.gray, "회색"))
        list.add(ColorData(R.color.mint, "민트색"))
        spinnerAdapter = SpinnerAdapter(this, R.layout.spinner, list)

        MG_marker.adapter = spinnerAdapter
        MG_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter?.nameChange(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        MG_delete.setOnClickListener(this)
        MG_save.setOnClickListener(this)
    }

    override fun setNameText(text: String) {
        MG_name.setText(text)
    }

    override fun activeSave(boolean: Boolean) {
        MG_save.isEnabled = boolean
    }

    override fun saveAlpha(float: Float) {
        MG_save.alpha = float
    }

    override fun setMarker(colorId: Int, colorText: String) {
        spinnerAdapter?.getPosition(ColorData(colorId, colorText))
            ?.let { MG_marker.setSelection(it) }
    }

    override fun setMemoText(text: String) {
        MG_memo.setText(text)
    }

    override fun finishActivity() {
        finish()
    }

    override fun progressVisible(boolean: Boolean) {
        if (boolean) {
            MG_progressBar.visibility = View.VISIBLE
        } else {
            MG_progressBar.visibility = View.INVISIBLE
        }
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.MG_save -> {
                presenter?.modifySave()
            }
            R.id.MG_delete -> {
                presenter?.deleteGroup()
            }
        }
    }
}
