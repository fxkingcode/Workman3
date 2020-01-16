package com.example.workman.View.StartPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.workman.R
import com.example.workman.View.Login.LoginActivity

class StartPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))

        }, 2000)

    }
}
