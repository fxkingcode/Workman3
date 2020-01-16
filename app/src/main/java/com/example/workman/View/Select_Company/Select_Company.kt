package com.example.workman.View.Select_Company

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.workman.R
import com.example.workman.View.Create_Company.Create_Company
import com.example.workman.View.Joining_Work.Joining_Work
import kotlinx.android.synthetic.main.activity_select_company.*

class Select_Company : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_company)
        // 툴바 설정하기
        val toolbar = findViewById(R.id.select_company_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)

        // 회사 만들기 클릭하였을때 회사 만들기 화면으로 이동한다.
        button_create_company.setOnClickListener {
            val intent = Intent(this, Create_Company::class.java)
            startActivity(intent)
        }

        // 직장 합류하기 버튼 눌렀을때 직장 합류하기 화면으로 이동한다.
        button_joining_work.setOnClickListener {
            val intent = Intent(this, Joining_Work::class.java)
            startActivity(intent)
        }
    }

    //액션버튼 메뉴 액션바에 집어 넣기
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.select_company_top_menu, menu)
        return true
    }

    //액션버튼 클릭 했을 때
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_settings -> {
                //설정 버튼 눌렀을 때
                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
