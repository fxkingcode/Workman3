package com.example.workman.Adapter.Holder

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Data.VacationItem
import com.example.workman.R
import kotlinx.android.synthetic.main.vacation_item.view.*
import java.text.DateFormat

class VacationViewHolder(val context: Context, parent: ViewGroup?) : RecyclerView.ViewHolder(
    LayoutInflater.from(context).inflate(R.layout.vacation_item, parent, false)
) {
    val VI_date = itemView.VI_date
    val VI_approved = itemView.VI_approved
    val VI_unapproved = itemView.VI_unapproved
    val VI_type = itemView.VI_type

    fun onBind(item: VacationItem) {
        if (item.type == "반차") {
            VI_date.text = "${DateFormat.getDateInstance(DateFormat.LONG).format(item.date)} ${item.startTime} - ${item.endTime}"
        } else {
            VI_date.text = DateFormat.getDateInstance(DateFormat.LONG).format(item.date)
        }

        VI_type.text = item.type

        if (item.approve)//승인
        {
            VI_unapproved.visibility = View.INVISIBLE
        } else {
            VI_approved.visibility = View.INVISIBLE
        }
    }
}