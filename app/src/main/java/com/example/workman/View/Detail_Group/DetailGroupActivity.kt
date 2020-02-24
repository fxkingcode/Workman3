package com.example.workman.View.Detail_Group

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.R
import com.example.workman.View.Modify_Employee.ModifyEmployeeActivity
import com.example.workman.View.Modify_Group.ModifyGroupActivity
import kotlinx.android.synthetic.main.activity_add_group.*
import kotlinx.android.synthetic.main.activity_detail_group.*

class DetailGroupActivity : AppCompatActivity(),DetailGroupContract.IDetailGroupView,
    View.OnClickListener {

    private var presenter:DetailGroupPresenter? = null
    private var MODIFYEMPLOYEE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_group)

        initialize()
        presenter?.getIntent(intent)
        presenter?.callGroup()
    }

    private fun initialize()
    {
        presenter = DetailGroupPresenter(this,this)

        DG_modify.setOnClickListener(this)
    }

    override fun setNameText(text: String) {
        DG_name.text = text
    }

    override fun setMarkerText(text: String) {
        DG_marker.text = text
    }

    override fun setMarkerBackground(int: Int) {
        DG_marker.setBackgroundColor(ContextCompat.getColor(this,int))
    }

    override fun setMemoText(text: String) {
        DG_memo.text = text
    }

    override fun setPersonnelText(text: String) {
        DG_personnel.text = text
    }

    override fun setEmployeesText(text: String) {
        DG_employees.text = text
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
            DG_progressBar.visibility = View.VISIBLE
        }else
        {
            DG_progressBar.visibility = View.INVISIBLE
        }
    }

    override fun modifyGroup(group:GroupDto) {
        val intent = Intent(this, ModifyGroupActivity::class.java)
        intent.putExtra("idx",group.id)
        intent.putExtra("marker",group.marker)
        intent.putExtra("name",group.name)
        intent.putExtra("memo",group.memo)
        startActivityForResult(intent,MODIFYEMPLOYEE)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.DG_modify -> {
                presenter?.modifyClick()
            }
        }
    }
}
