package com.example.workman.View.SelectGroup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workman.Adapter.EmployeeAdapter
import com.example.workman.Adapter.GroupAdapter
import com.example.workman.Model.DTO.GroupCheck
import com.example.workman.R
import com.example.workman.View.Employee.EmployeePresenter
import com.example.workman.View.Request_Vacation.ReqvacationPresenter
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import kotlinx.android.synthetic.main.activity_reqvacation.*
import kotlinx.android.synthetic.main.activity_select_group.*

class SelectGroupActivity : AppCompatActivity(), SelectGroupContract.ISelectGroupView,
    View.OnClickListener {

    private var presenter: SelectGroupPresenter? = null
    private var groupAdapter: GroupAdapter? = null
    private var layoutmanager: LinearLayoutManager? = null
    private var allSelectCheck: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_group)

        initialize()
        presenter?.callGroups()
    }

    private fun initialize() {
        groupAdapter = GroupAdapter(this, 2)
        layoutmanager = LinearLayoutManager(this)

        presenter = SelectGroupPresenter(this, this).apply {
            adapterModel = groupAdapter
            adapterView = groupAdapter
        }

        SG_recyclerview.run {
            layoutManager = layoutmanager
            adapter = groupAdapter
        }

        SG_allSelect.setOnClickListener(this)
        SG_complete.setOnClickListener(this)
    }

    override fun finishActivity(arrayList: ArrayList<GroupCheck>) {
        setResult(Activity.RESULT_OK, Intent().putExtra("GroupCheck",arrayList))
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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.SG_allSelect -> {
                presenter?.allSelectClick(allSelectCheck)
                allSelectCheck = !allSelectCheck
            }
            R.id.SG_complete -> {
                presenter?.complete()
            }
        }
    }
}
