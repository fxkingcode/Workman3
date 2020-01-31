package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R
import kotlinx.android.synthetic.main.vacation_item.view.*
import kotlinx.android.synthetic.main.waiting_vacation_item.view.*
import java.text.DateFormat

class WaitingVacationViewHolder(
    val context: Context, parent: ViewGroup?, val listenerFunc: ((Int) -> Unit)?,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    val WVI_date = itemView.WVI_date
    val WVI_type = itemView.WVI_type
    val WVI_name = itemView.WVI_name

    fun onBind(item: VacationItem, position: Int) {
        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }

        if (item.type == "반차") {
            WVI_date.text =
                "${DateFormat.getDateInstance(DateFormat.LONG).format(item.date)} ${item.startTime} - ${item.endTime}"
        } else {
            WVI_date.text = DateFormat.getDateInstance(DateFormat.LONG).format(item.date)
        }

        WVI_type.text = "[${item.type}]"

        WVI_name.text = "${item.name} (${item.email})"
    }
}