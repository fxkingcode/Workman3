package com.example.workman.View.Add_Group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.workman.Model.DTO.ColorData
import com.example.workman.Adapter.SpinnerAdapter
import com.example.workman.R
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_add_group.*
import kotlinx.android.synthetic.main.activity_group.*

class AddGroupActivity : AppCompatActivity(),AddGroupContract.IAddGroupView,View.OnClickListener {

    private var spinnerAdapter:SpinnerAdapter? = null
    private var presenter:AddGroupPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_group)

        initialize()
    }

    private fun initialize()
    {
        presenter = AddGroupPresenter(this,this)

        val list:ArrayList<ColorData> = ArrayList()
        list.add(ColorData(R.color.black, "검정색"))
        list.add(ColorData(R.color.blue, "파란색"))
        list.add(ColorData(R.color.red, "빨간색"))
        list.add(ColorData(R.color.green, "초록색"))
        list.add(ColorData(R.color.gray, "회색"))
        list.add(ColorData(R.color.mint, "민트색"))
        spinnerAdapter = SpinnerAdapter(this, R.layout.spinner,list)

        AG_marker.adapter = spinnerAdapter
        AG_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter?.nameChange(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        AG_create.setOnClickListener(this)
    }

    override fun createButtonEnable(boolean: Boolean)
    {
        AG_create.isEnabled = boolean
    }

    override fun createButtonAlpha(float: Float)
    {
        AG_create.alpha = float
    }

    override fun finishActivity() {
        finish()
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun progressVisible(boolean: Boolean) {
        if(boolean)
        {
            AG_progressBar.visibility = View.VISIBLE
        }else
        {
            AG_progressBar.visibility = View.INVISIBLE
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.AE_create -> {
                presenter?.createClick()
            }
        }
    }
}
