package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R
import kotlinx.android.synthetic.main.vacation_item.view.*
import java.text.DateFormat

class VacationViewHolder(
    val context: Context, parent: ViewGroup?, val listenerFunc: ((Int) -> Unit)?,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    val VI_date = itemView.VI_date
    val VI_state = itemView.VI_state
    val VI_type = itemView.VI_type

    fun onBind(item: VacationItem, position: Int) {
        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }

        if (item.type == "반차") {
            VI_date.text =
                "${DateFormat.getDateInstance(DateFormat.LONG).format(item.date)} ${item.startTime} - ${item.endTime}"
        } else {
            VI_date.text = DateFormat.getDateInstance(DateFormat.LONG).format(item.date)
        }

        VI_type.text = "[${item.type}]"

        when {
            item.approve == null -> {
                VI_state.text = "대기"
                VI_state.setTextColor(ContextCompat.getColor(context,R.color.yellow))
            }
            item.approve == true -> {
                VI_state.text = "승인"
                VI_state.setTextColor(ContextCompat.getColor(context,R.color.green))
            }
            item.approve == false -> {
                VI_state.text = "거부"
                VI_state.setTextColor(ContextCompat.getColor(context,R.color.red))
            }
        }
    }
}