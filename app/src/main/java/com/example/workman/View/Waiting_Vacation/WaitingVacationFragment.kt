package com.example.workman.View.Waiting_Vacation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workman.Adapter.VacationAdapter

import com.example.workman.R
import com.example.workman.View.Detail_Vacation.DetailvacaActivity
import com.example.workman.decorator.RangeDayDecorator
import com.example.workman.decorator.SaturdayDecorator
import com.example.workman.decorator.SundayDecorator
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import kotlinx.android.synthetic.main.fragment_employee_vacation.*
import kotlinx.android.synthetic.main.fragment_waiting_vacation.*
import kotlinx.android.synthetic.main.fragment_waiting_vacation.MVW_recyclerView
import kotlinx.android.synthetic.main.fragment_waiting_vacation.view.*
import java.util.*

class WaitingVacationFragment : Fragment(),View.OnClickListener,WaitingVacationContract.IWaitingVacationView {

    private var presenter: WaitingVacationPresenter? = null
    private var vacationAdapter: VacationAdapter? = null
    private var layoutmanager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialize()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_waiting_vacation, container, false)
        return uiInitialize(view)
    }

    private fun initialize() {
        vacationAdapter = context?.let { VacationAdapter(it, 2) }

        layoutmanager = LinearLayoutManager(context)

        presenter = context?.let {
            WaitingVacationPresenter(it, this).apply {
                adapterModel = vacationAdapter
                adapterView = vacationAdapter
            }
        }
    }

    private fun uiInitialize(view: View): View {
        view.run {
            MVW_recyclerView.run {
                layoutManager = layoutmanager
                adapter = vacationAdapter
            }

            return this
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter?.callItems(
            Date(System.currentTimeMillis()),
            Date(System.currentTimeMillis()),
            false
        )
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun finishActivity() {
        activity?.finish()
    }

    override fun progressVisible() {
        MVW_progressBar.visibility = View.VISIBLE
    }

    override fun progressInvisible() {
        MVW_progressBar.visibility = View.INVISIBLE
    }

    override fun toastMessage(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
    override fun detailVacation(idx: Int) {
        startActivity(Intent(context, DetailvacaActivity::class.java).putExtra("idx", idx))
    }
}
