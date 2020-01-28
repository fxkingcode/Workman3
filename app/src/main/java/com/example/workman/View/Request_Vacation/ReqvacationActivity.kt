package com.example.workman.View.Request_Vacation

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.workman.R
import com.example.workman.View.Vacation.VacationPresenter
import com.example.workman.decorator.RangeDayDecorator
import com.example.workman.decorator.SaturdayDecorator
import com.example.workman.decorator.SundayDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.MaterialCalendarView.*
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener
import kotlinx.android.synthetic.main.activity_reqvacation.*
import kotlinx.android.synthetic.main.activity_vacation.*

class ReqvacationActivity : AppCompatActivity(), ReqvacationContract.IReqvacationView,
    OnDateSelectedListener, View.OnClickListener {

    private lateinit var presenter: ReqvacationPresenter

    private val sundayDecorator: SundayDecorator =
        SundayDecorator()
    private val saturdayDecorator: SaturdayDecorator =
        SaturdayDecorator()

    lateinit var typeAdapter: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reqvacation)

        initialize()
    }

    private fun initialize() {
        presenter = ReqvacationPresenter(this, this)
        RV_calendarView.run {
            selectionMode = SELECTION_MODE_MULTIPLE
            addDecorators(sundayDecorator, saturdayDecorator)
            setOnDateChangedListener(this@ReqvacationActivity)
            isDynamicHeightEnabled = true
        }

        typeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.vacationtype,
            android.R.layout.simple_dropdown_item_1line
        )

        RV_type.run {
            adapter = typeAdapter
            setSelection(typeAdapter.getPosition("연차"))
            onItemSelectedListener = object : OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    presenter.timeActivate(parent!!.getItemAtPosition(position).toString())
                }
            }
        }

        RV_startbutton.setOnClickListener(this)
        RV_endbutton.setOnClickListener(this)
        RV_apply.setOnClickListener(this)
    }

    override fun onDateSelected(
        widget: MaterialCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {
        presenter.applyActivate(widget.selectedDates.size)
    }

    override fun applyEnable(boolean: Boolean) {
        if (boolean) {
            RV_apply.run {
                isEnabled = true
                setTextColor(ContextCompat.getColor(this@ReqvacationActivity, R.color.blue))
            }
        } else {
            RV_apply.run {
                isEnabled = false
                setTextColor(
                    ContextCompat.getColor(
                        this@ReqvacationActivity,
                        R.color.transparentblue
                    )
                )
            }
        }
    }

    override fun startTimeEnable(boolean: Boolean) {
        RV_startbutton.isEnabled = boolean
    }

    override fun endTimeEnable(boolean: Boolean) {
        RV_endbutton.isEnabled = boolean
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

    override fun createTimePicker(message: String) {
        val dialog: TimePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                Toast.makeText(this, "$hourOfDay : $minute", Toast.LENGTH_LONG).show()

                if (message == "시작 시간") {
                    presenter.setStartTime(hourOfDay, minute)
                } else {
                    presenter.setEndTime(hourOfDay, minute)
                }
            }, 0, 0, false
        )
        dialog.setMessage(message)
        dialog.show()
    }

    override fun startTimeText(text: String) {
        RV_startbutton.text = text
    }

    override fun endTimeText(text: String) {
        RV_endbutton.text = text
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.RV_startbutton -> {
                presenter.startTimeClick()
            }
            R.id.RV_endbutton -> {
                presenter.endTimeClick()
            }
            R.id.RV_apply -> {
                presenter.apply(
                    RV_calendarView.selectedDates,
                    RV_type.selectedItem.toString(),
                    RV_startbutton.text.toString(),
                    RV_endbutton.text.toString(),
                    RV_reason.text.toString()
                )
            }
        }
    }
}
