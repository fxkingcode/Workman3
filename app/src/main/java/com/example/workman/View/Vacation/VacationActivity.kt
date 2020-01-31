package com.example.workman.View.Vacation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_vacation.*
import android.view.View
import com.example.workman.decorator.SaturdayDecorator
import com.example.workman.decorator.SundayDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import java.util.*
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workman.Adapter.VacationAdapter
import com.example.workman.R
import com.example.workman.View.Detail_Vacation.DetailvacaActivity
import com.example.workman.View.Request_Vacation.ReqvacationActivity
import com.example.workman.decorator.RangeDayDecorator
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener
import java.text.DateFormat
import java.text.SimpleDateFormat


class VacationActivity : AppCompatActivity(), VacationContract.IVacationView,
    OnRangeSelectedListener, OnDateSelectedListener {

    private lateinit var vacationAdapter: VacationAdapter
    private lateinit var presenter: VacationPresenter
    private val layoutManager: LinearLayoutManager = LinearLayoutManager(this)

    private val format: DateFormat = SimpleDateFormat("MM월 dd일")
    private val animation1: Animation =
        AlphaAnimation(0f, 1f).apply { this.duration = 500 }//나타나는 애니메이션
    private val animation2: Animation =
        AlphaAnimation(1f, 0f).apply { this.duration = 500 }//사라지는 애니메이션

    private val sundayDecorator: SundayDecorator =
        SundayDecorator()
    private val saturdayDecorator: SaturdayDecorator =
        SaturdayDecorator()
    private val rangeDayDecorator: RangeDayDecorator =
        RangeDayDecorator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacation)

        initialize()
        presenter.callItems(
            Date(System.currentTimeMillis()),
            Date(System.currentTimeMillis()),
            false
        )

        V_fab.setOnClickListener {
            startActivity(Intent(this, ReqvacationActivity::class.java))
        }

        V_calendarbutton.setOnClickListener {
            if (V_calendarView.visibility == View.GONE) {
                V_calendarView.run {
                    visibility = View.VISIBLE
                    startAnimation(animation1)
                    clearSelection()
                }
            } else {
                V_calendarView.run {
                    startAnimation(animation2)
                    visibility = View.GONE
                }
            }
        }
    }

    private fun initialize() {
        vacationAdapter = VacationAdapter(this,0)
        V_recyclerView.layoutManager = layoutManager
        V_recyclerView.adapter = vacationAdapter

        presenter = VacationPresenter(this, this).apply {
            adapterModel = vacationAdapter
            adapterView = vacationAdapter
        }

        V_calendarbutton.text = format.format(Date(System.currentTimeMillis()))

        V_calendarView.run {
            this.selectionMode = MaterialCalendarView.SELECTION_MODE_RANGE
            this.setDateSelected(Date(System.currentTimeMillis()), true)
            this.addDecorators(sundayDecorator, saturdayDecorator, rangeDayDecorator)
            this.setOnRangeSelectedListener(this@VacationActivity)
            this.setOnDateChangedListener(this@VacationActivity)
        }

    }

    override fun onDateSelected(
        widget: MaterialCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {
        if (!selected) {
            presenter.callItems(date.date, date.date, true)
            V_calendarbutton.text = format.format(date.date)
            widget.visibility = View.GONE
            widget.startAnimation(animation2)
        }
    }

    override fun onRangeSelected(widget: MaterialCalendarView, dates: MutableList<CalendarDay>) {
        presenter.callItems(dates[0].date, dates[dates.size - 1].date, true)
        rangeDayDecorator.addFirstAndLast(dates[0], dates[dates.size - 1])

        V_calendarbutton.text =
            "${format.format(dates[0].date)} - ${format.format(dates[dates.size - 1].date)}"
        widget.visibility = View.GONE
        widget.startAnimation(animation2)
    }

    override fun finishActivity() {
        finish()
    }

    override fun progressVisible() {
        V_progressBar.visibility = View.VISIBLE
    }

    override fun progressInvisible() {
        V_progressBar.visibility = View.INVISIBLE
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    override fun detailVacation(idx: Int) {
        startActivity(Intent(this, DetailvacaActivity::class.java).putExtra("idx",idx))
    }
}
