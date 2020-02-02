package com.example.workman.View.Manager_Vacation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.workman.R
import com.example.workman.View.Detail_Vacation.DetatilvacaPresenter
import com.example.workman.View.Employee_Vacation.EmployeeVacationFragment
import com.example.workman.View.My_Vacation.MyVacationFragment
import com.example.workman.View.Waiting_Vacation.WaitingVacationFragment
import kotlinx.android.synthetic.main.activity_detailvaca.*
import kotlinx.android.synthetic.main.activity_manager_vacation.*

class ManagerVacationActivity : AppCompatActivity(), ManagerVacationContract.IManagerVacationView,
    View.OnClickListener {

    private var presenter: ManagerVacationPresenter? = null
    private var myVacationFragment: MyVacationFragment? = null
    private var employeeVacationFragment: EmployeeVacationFragment? = null
    private var waitingVacationFragment: WaitingVacationFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_vacation)

        initialize()
        presenter?.myVacation()
    }

    private fun initialize() {
        presenter = ManagerVacationPresenter(this, this)
        myVacationFragment = MyVacationFragment()
        employeeVacationFragment = EmployeeVacationFragment()
        waitingVacationFragment = WaitingVacationFragment()

        MV_myVacation.setOnClickListener(this)
        MV_employeeVacation.setOnClickListener(this)
        MV_waitingVacation.setOnClickListener(this)
    }

    override fun changeMyFragemnt() {
        myVacationFragment?.let {
            supportFragmentManager.beginTransaction().replace(
                R.id.MV_container,
                it
            ).commit()
        }
    }

    override fun changeEmployeeFragemnt() {
        employeeVacationFragment?.let {
            supportFragmentManager.beginTransaction().replace(
                R.id.MV_container,
                it
            ).commit()
        }
    }

    override fun changeWaitingFragemnt() {
        waitingVacationFragment?.let {
            supportFragmentManager.beginTransaction().replace(
                R.id.MV_container,
                it
            ).commit()
        }
    }

    override fun myButtonEnable(boolean: Boolean) {
        MV_myVacation.isEnabled = boolean
    }

    override fun employeeButtonEnable(boolean: Boolean) {
        MV_employeeVacation.isEnabled = boolean
    }

    override fun waitingButtonEnable(boolean: Boolean) {
        MV_waitingVacation.isEnabled = boolean
    }

    override fun finishActivity() {
        finish()
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun setMyBackground(id: Int?) {
        if (id == null) {
            MV_myVacation.background = null
        } else {
            MV_myVacation.background = ContextCompat.getDrawable(this, id)
        }
    }

    override fun setEmployeeBackground(id: Int?) {
        if (id == null) {
            MV_employeeVacation.background = null
        } else {
            MV_employeeVacation.background = ContextCompat.getDrawable(this, id)
        }
    }

    override fun setWaitingBackground(id: Int?) {
        if (id == null) {
            MV_waitingVacation.background = null
        } else {
            MV_waitingVacation.background = ContextCompat.getDrawable(this, id)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.MV_myVacation -> {
                presenter?.myVacation()
            }
            R.id.MV_employeeVacation -> {
                presenter?.employeeVacation()
            }
            R.id.MV_waitingVacation -> {
                presenter?.waitingVacation()
            }
        }
    }
}
