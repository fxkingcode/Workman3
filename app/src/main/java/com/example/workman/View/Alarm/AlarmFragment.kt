package com.example.workman.View.Alarm


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workman.R
import com.example.workman.View.Create_Alarm.Create_Alarm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_alarm.*

/**
 * 알람
 */
class AlarmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 툴바 타이틀 변경하기.
        activity!!.toolbar.title = "알람"
        activity!!.toolbar.setTitleTextColor(Color.WHITE)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.floatingActionButton_Create_Alarm.setOnClickListener {
            val intent = Intent(context, Create_Alarm::class.java)
            startActivity(intent)
        }
    }


}