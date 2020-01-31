package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R
import kotlinx.android.synthetic.main.employee_vacation_item.view.*
import kotlinx.android.synthetic.main.vacation_item.view.*
import java.text.DateFormat

class EmployeeVacationViewHolder(
    val context: Context, parent: ViewGroup?, val listenerFunc: ((Int) -> Unit)?,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    val EVI_date = itemView.EVI_date
    val EVI_state = itemView.EVI_state
    val EVI_type = itemView.EVI_type
    val EVI_name = itemView.EVI_name

    fun onBind(item: VacationItem, position: Int) {
        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }

        if (item.type == "반차") {
            EVI_date.text =
                "${DateFormat.getDateInstance(DateFormat.LONG).format(item.date)} ${item.startTime} - ${item.endTime}"
        } else {
            EVI_date.text = DateFormat.getDateInstance(DateFormat.LONG).format(item.date)
        }

        EVI_type.text = "[${item.type}]"

        when {
            item.approve == null -> {
                EVI_state.text = "대기"
                EVI_state.setTextColor(ContextCompat.getColor(context, R.color.yellow))
            }
            item.approve == true -> {
                EVI_state.text = "승인"
                EVI_state.setTextColor(ContextCompat.getColor(context, R.color.green))
            }
            item.approve == false -> {
                EVI_state.text = "거부"
                EVI_state.setTextColor(ContextCompat.getColor(context, R.color.red))
            }
        }

        EVI_name.text = "${item.name} (${item.email})"
    }
}