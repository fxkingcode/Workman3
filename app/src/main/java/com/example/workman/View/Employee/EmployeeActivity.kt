package com.example.workman.View.Employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workman.Adapter.EmployeeAdapter
import com.example.workman.View.Add_Employee.AddEmployeeActivity
import com.example.workman.R
import kotlinx.android.synthetic.main.activity_employee.*

class EmployeeActivity : AppCompatActivity(), EmployeeContract.IEmployeeView,View.OnClickListener{

    private var presenter: EmployeePresenter? = null
    private var employeeActiveAdapter: EmployeeAdapter? = null
    private var employeePassiveAdapter: EmployeeAdapter? = null
    private var layoutmanager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        initialize()
        presenter?.activeEmployee()
    }

    private fun initialize() {
        employeeActiveAdapter = EmployeeAdapter(this,0)
        employeePassiveAdapter = EmployeeAdapter(this,1)

        layoutmanager = LinearLayoutManager(this)

        presenter = EmployeePresenter(this, this).apply {
            adapterActiveModel = employeeActiveAdapter
            adapterActiveView = employeeActiveAdapter
            adapterPassiveModel = employeePassiveAdapter
            adapterPassiveView = employeePassiveAdapter
        }

        E_recyclerView.layoutManager = layoutmanager

        E_activebutton.setOnClickListener(this)
        E_passivebutton.setOnClickListener(this)
    }

    override fun changeActiveAdapter()
    {
        E_recyclerView.adapter = employeeActiveAdapter
    }

    override fun changePassiveAdapter()
    {
        E_recyclerView.adapter = employeePassiveAdapter
    }

    override fun activeButtonEnable(boolean: Boolean) {
        E_activebutton.isEnabled = boolean
    }

    override fun passiveButtonEnable(boolean: Boolean) {
        E_passivebutton.isEnabled = boolean
    }

    override fun setActiveBackground(id: Int?) {
        if (id == null) {
            E_activebutton.background = null
        } else {
            E_activebutton.background = ContextCompat.getDrawable(this, id)
        }
    }

    override fun setPassiveBackground(id: Int?) {
        if (id == null) {
            E_passivebutton.background = null
        } else {
            E_passivebutton.background = ContextCompat.getDrawable(this, id)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.E_activebutton -> {
                presenter?.activeEmployee()
            }
            R.id.E_passivebutton -> {
                presenter?.passiveEmployee()
            }
            R.id.E_fab -> {
                startActivity(Intent(this, AddEmployeeActivity::class.java))
            }
        }
    }
    override fun finishActivity() {
        finish()
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun detailEmployee(idx:Int)
    {
//        startActivity(Intent(this, Detail::class.java).putExtra("idx", idx))
    }
}
