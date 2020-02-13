package com.example.workman.View.Detail_Vacation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.workman.R
import com.example.workman.View.Request_Vacation.ReqvacationPresenter
import kotlinx.android.synthetic.main.activity_detailvaca.*
import kotlinx.android.synthetic.main.activity_reqvacation.*

class DetailvacaActivity : AppCompatActivity(), DetailvacaContract.IDetailvacaView,
    View.OnClickListener {
    private var idx: Int? = null

    private lateinit var presenter: DetatilvacaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailvaca)

        initialize()
        idx?.let { presenter.callVacation(it) }
    }

    private fun initialize() {
        presenter = DetatilvacaPresenter(this, this)
        idx = intent.getIntExtra("idx", -1)

        DV_cancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.DV_cancel -> {
                idx?.let { presenter.cancelVacation(it) }
            }
        }
    }

    override fun finishActivity() {
        finish()
    }

    override fun progressVisible() {
        DV_progressBar.visibility = View.VISIBLE
    }

    override fun progressInvisible() {
        DV_progressBar.visibility = View.INVISIBLE
    }

    override fun toastMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun setButtonVisible(boolean: Boolean) {
        if (true) {
            DV_cancel.visibility = View.VISIBLE
        } else {
            DV_cancel.visibility = View.GONE
        }
    }
    override fun setTimeColor(color: Int) {
        DV_startTime.setTextColor(color)
        DV_endTime.setTextColor(color)
        DV_startTimeText.setTextColor(color)
        DV_endTimeText.setTextColor(color)
    }

    override fun setApproveColor(color: Int) {
        DV_approve.setTextColor(color)
    }

    override fun setName(text: String) {
        DV_name.text = text
    }

    override fun setType(text: String) {
        DV_type.text = text
    }

    override fun setDate(date: String) {
        DV_date.text = date
    }

    override fun setStartTime(text: String) {
        DV_startTime.text = text
    }

    override fun setEndTime(text: String) {
        DV_endTime.text = text
    }

    override fun setApprove(text: String) {
        DV_approve.text = text
    }

    override fun setApproveManager(text: String) {
        DV_approveManager.text = text
    }

    override fun setApproveTime(text: String) {
        DV_approveTime.text = text
    }

    override fun setApproveManagerText(text: String) {
        DV_approveManagerText.text = text
    }

    override fun setApproveTimeText(text: String) {
        DV_approveTimeText.text = text
    }

    override fun setReason(text: String) {
        DV_reason.text = text
    }

    override fun getIdx(): Int? = idx
}
