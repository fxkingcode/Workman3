package com.example.workman.View.My_Vacation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workman.Adapter.VacationAdapter

import com.example.workman.R
import com.example.workman.View.Detail_Vacation.DetailvacaActivity
import com.example.workman.Decorator.RangeDayDecorator
import com.example.workman.Decorator.SaturdayDecorator
import com.example.workman.Decorator.SundayDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener
import kotlinx.android.synthetic.main.fragment_my_vacation.*
import kotlinx.android.synthetic.main.fragment_my_vacation.view.*
import java.util.*

class MyVacationFragment : Fragment(), MyVacationContract.IMyVacationView, View.OnClickListener,
    OnRangeSelectedListener,
    OnDateSelectedListener {

    private var presenter: MyVacationPresenter? = null
    private var vacationAdapter: VacationAdapter? = null
    private var layoutmanager: LinearLayoutManager? = null

    private var animation1: Animation? = null
    private var animation2: Animation? = null

    private var sundayDecorator: SundayDecorator? = null
    private var saturdayDecorator: SaturdayDecorator? = null
    private var rangeDayDecorator: RangeDayDecorator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialize()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_my_vacation, container, false)

        return uiInitialize(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter?.calendarButtonTextFormat(
            Date(System.currentTimeMillis()),
            Date(System.currentTimeMillis())
        )

        presenter?.callItems(
            Date(System.currentTimeMillis()),
            Date(System.currentTimeMillis()),
            false
        )
    }

    private fun initialize() {
        vacationAdapter = context?.let { VacationAdapter(it, 0) }

        layoutmanager = LinearLayoutManager(context)

        presenter = context?.let {
            MyVacationPresenter(it, this).apply {
                adapterModel = vacationAdapter
                adapterView = vacationAdapter
            }
        }

        animation1 = AlphaAnimation(0f, 1f).apply { this.duration = 500 }//나타나는 애니메이션
        animation2 = AlphaAnimation(1f, 0f).apply { this.duration = 500 }//사라지는 애니메이션

        sundayDecorator = SundayDecorator()
        saturdayDecorator = SaturdayDecorator()
        rangeDayDecorator = RangeDayDecorator()
    }

    private fun uiInitialize(view: View): View {
        view.run {
            MVM_recyclerView.run {
                layoutManager = layoutmanager
                adapter = vacationAdapter
            }

            MVM_calendarbutton.run {
                setOnClickListener(this@MyVacationFragment)
            }

            MVM_calendarView.run {
                selectionMode = MaterialCalendarView.SELECTION_MODE_RANGE
                setDateSelected(Date(System.currentTimeMillis()), true)
                addDecorators(sundayDecorator, saturdayDecorator, rangeDayDecorator)
                setOnRangeSelectedListener(this@MyVacationFragment)
                setOnDateChangedListener(this@MyVacationFragment)
            }

            return this
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.MVM_calendarbutton -> {
                presenter?.calendarButtonClick()
            }
        }
    }

    override fun setCalendarVisible() {
        if (MVM_calendarView.visibility == View.GONE) {
            MVM_calendarView.run {
                visibility = View.VISIBLE
                startAnimation(animation1)
                clearSelection()
            }
        } else {
            MVM_calendarView.run {
                startAnimation(animation2)
                visibility = View.GONE
            }
        }
    }

    override fun onDateSelected(
        widget: MaterialCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {
        if (!selected) {
            presenter?.callItems(date.date, date.date, true)
            presenter?.calendarButtonTextFormat(date.date, date.date)
            presenter?.calendarButtonClick()
        }
    }

    override fun onRangeSelected(widget: MaterialCalendarView, dates: MutableList<CalendarDay>) {
        rangeDayDecorator?.addFirstAndLast(dates[0], dates[dates.size - 1])

        presenter?.callItems(dates[0].date, dates[dates.size - 1].date, true)
        presenter?.calendarButtonTextFormat(dates[0].date, dates[dates.size - 1].date)
        presenter?.calendarButtonClick()
    }

    override fun detailVacation(idx: Int) {
        startActivity(Intent(context, DetailvacaActivity::class.java).putExtra("idx", idx))
    }

    override fun setCalendarButtonText(text: String) {
        MVM_calendarbutton.text = text
    }

    override fun finishActivity() {
        activity?.finish()
    }

    override fun progressVisible() {
        MVM_progressBar.visibility = View.VISIBLE
    }

    override fun progressInvisible() {
        MVM_progressBar.visibility = View.INVISIBLE
    }

    override fun toastMessage(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
