package com.example.workman.View.Create_Company

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import com.example.workman.R
import com.example.workman.View.Add_Work_Location.Add_Work_Location
import com.example.workman.View.Select_Company.Select_Company
import kotlinx.android.synthetic.main.activity_create_company.*

class Create_Company : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_company)
        // 툴바 설정하기
        val toolbar = findViewById(R.id.create_company_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)  // 뒤로가기 버튼 추가.

        // 회사 인원수를 정하는 스피너 셋팅
        val spinner_personnel = findViewById<Spinner>(R.id.spinner_personnel)
        val spinner_adapter = ArrayAdapter.createFromResource(this, R.array.Number_of_people,android.R.layout.simple_spinner_item)

        // 인원수 스피너에 아답터 연결
        spinner_personnel.adapter = spinner_adapter
        spinner_personnel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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

        // 취소 버튼 눌렀을떄 회사 선택화면으로 이동하고 지금 화면은 없어진다.
        button_cancel.setOnClickListener {
            val intent = Intent(this, Select_Company::class.java)
            startActivity(intent)
            finish()
        }

        // 다음 버튼 눌렀을때 직장위치 추가하기 화면으로 이동한다.
        button_next.setOnClickListener {
            val intent = Intent(this, Add_Work_Location::class.java)
            startActivity(intent)
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
