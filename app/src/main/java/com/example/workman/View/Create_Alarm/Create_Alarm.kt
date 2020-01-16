package com.example.workman.View.Create_Alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import com.example.workman.R
import kotlinx.android.synthetic.main.activity_create_alarm.*

class Create_Alarm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alarm)
        // 툴바 설정하기
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)  // 뒤로가기 버튼 추가.

        // 원하는 알람을 체크했을때 다른 알람 아이템들 화면에 나오게한다.
        checkBox_Day_of_week_repeat.setOnClickListener {
            if (checkBox_Day_of_week_repeat.isChecked){
                checkBox_Working_hours_alarm.isChecked = false
                button_Day_of_week.visibility = View.VISIBLE
                spinner_Working_hours_alarm.visibility = View.GONE
            } else{
                button_Day_of_week.visibility = View.GONE
            }

        }
        checkBox_Working_hours_alarm.setOnClickListener {
            if(checkBox_Working_hours_alarm.isChecked){
                checkBox_Day_of_week_repeat.isChecked = false
                spinner_Working_hours_alarm.visibility = View.VISIBLE
                button_Day_of_week.visibility = View.GONE
            } else{
                spinner_Working_hours_alarm.visibility = View.GONE
            }
        }

        // 근무조에 따라 울리는 알람을 정하는 스피너 셋팅
        val spinner_Alarm = findViewById<Spinner>(R.id.spinner_Working_hours_alarm)
        val spinner_adapter = ArrayAdapter.createFromResource(this,R.array.Working_hours_alarm,android.R.layout.simple_spinner_item)

        // 인원수 스피너에 아답터 연결
        spinner_Alarm.adapter = spinner_adapter
        spinner_Alarm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

        }
    }

    // 툴바 뒤로가기 버튼 설정
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
