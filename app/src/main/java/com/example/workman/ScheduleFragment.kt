package com.example.workman


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.fragment_schedule.view.*

/**
 * 근무일정
 */
class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_schedule, container, false)

        // 플로팅액션버튼
        // 근무조 설정
        rootView.f_schedule_Floating_menu_item1.setOnClickListener {
            val nextIntent = Intent(activity, ScheduleGroupSet1::class.java)
            startActivity(nextIntent)
        }

        //근무리스트 설정
        rootView.f_schedule_Floating_menu_item2.setOnClickListener {
            val nextIntent = Intent(activity, ScheduleListSet::class.java)
            startActivity(nextIntent)
        }

        return rootView
    }


}
