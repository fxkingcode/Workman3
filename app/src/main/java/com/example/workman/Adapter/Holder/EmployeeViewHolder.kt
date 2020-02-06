package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R
import kotlinx.android.synthetic.main.employee_item.view.*
import kotlinx.android.synthetic.main.employee_vacation_item.view.*
import java.text.DateFormat

class EmployeeViewHolder(
    val context: Context, parent: ViewGroup?, val listenerFunc: ((Int) -> Unit)?,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    val EI_name = itemView.EI_name
    val EI_state = itemView.EI_state
    val EI_line = itemView.EI_line
    val EI_position = itemView.EI_position

    fun onActiveBind(item: EmployeeDto, position: Int, items: ArrayList<EmployeeDto>) {
        if (position != 0) {
            if (items[position - 1].position != items[position].position) {
                EI_position.visibility = View.VISIBLE
                EI_position.text = item.position
            }
        } else {
            EI_position.visibility = View.VISIBLE
            EI_position.text = item.position
        }

        if (position != items.size - 1) {
            if (items[position].position != items[position + 1].position) {
                EI_line.visibility = View.VISIBLE
            }
        } else {
            EI_line.visibility = View.VISIBLE
        }

        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }

        EI_name.text = item.name
        if (item.state!!) {
            EI_state.text = "합류"
            EI_state.setTextColor(ContextCompat.getColor(context, R.color.green))
        } else {
            EI_state.text = "미합류"
            EI_state.setTextColor(ContextCompat.getColor(context, R.color.red))
        }
    }

    fun onPassiveBind(item: EmployeeDto, position: Int, items: ArrayList<EmployeeDto>) {
        if (position != 0) {
            if (items[position - 1].position != items[position].position) {
                EI_position.visibility = View.VISIBLE
                EI_position.text = item.position
            }
        } else {
            EI_position.visibility = View.VISIBLE
            EI_position.text = item.position
        }

        if (position != items.size - 1) {
            if (items[position].position != items[position + 1].position) {
                EI_line.visibility = View.VISIBLE
            }
        } else {
            EI_line.visibility = View.VISIBLE
        }

        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }

        EI_name.text = item.name
        EI_state.visibility = View.GONE
    }
}