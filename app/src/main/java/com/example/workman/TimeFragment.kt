package com.example.workman


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 출퇴근
 */
class TimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 툴바 타이틀 변경하기
        activity!!.toolbar.title = "출퇴근"
        activity!!.toolbar.setTitleTextColor(Color.WHITE)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time, container, false)
    }


}
