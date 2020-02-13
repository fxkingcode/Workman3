package com.example.workman.View.Detail_Group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.workman.R
import kotlinx.android.synthetic.main.activity_add_group.*
import kotlinx.android.synthetic.main.activity_detail_group.*

class DetailGroupActivity : AppCompatActivity(),DetailGroupContract.IDetailGroupView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_group)
    }

    override fun finishActivity() {
        finish()
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun progressVisible(boolean: Boolean) {
        if(boolean)
        {
            DG_progressBar.visibility = View.VISIBLE
        }else
        {
            DG_progressBar.visibility = View.INVISIBLE
        }
    }
}
