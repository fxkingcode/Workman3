package com.example.workman.Decorator

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.DayViewDecorator


class RangeDayDecorator : DayViewDecorator {

    private val list = HashSet<CalendarDay>()

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return list.contains(day)
    }

    override fun decorate(view: DayViewFacade) {
        return
    }



    /**
     * We're changing the dates, so make sure to call [MaterialCalendarView.invalidateDecorators]
     */
    fun addFirstAndLast(first: CalendarDay, last: CalendarDay) {
        list.clear()
        list.add(first)
        list.add(last)
    }
}