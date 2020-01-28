package com.example.workman


import android.content.Intent
import android.graphics.Color

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workman.View.Vacation.VacationActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_menu.view.*

/**
 * 더보기
 */
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)

        // 툴바 타이틀 변경하기
        activity!!.toolbar.title = "더보기"
        activity!!.toolbar.setTitleTextColor(Color.WHITE)

        rootView.myprofilebutton.setOnClickListener {
            val nextIntent = Intent(activity, MyprofileActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.companyprofilebutton.setOnClickListener {
            val nextIntent = Intent(activity, CompanyprofileActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.employeebutton.setOnClickListener {
            val nextIntent = Intent(activity, EmployeeActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.vacationbutton.setOnClickListener {
            val nextIntent = Intent(activity, VacationActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.groupbutton.setOnClickListener {
            val nextIntent = Intent(activity, GroupActivity::class.java)
            startActivity(nextIntent)
        }

        // Inflate the layout for this fragment
        return rootView
    }
}
