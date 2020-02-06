package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupCheck
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.R
import kotlinx.android.synthetic.main.employee_item.view.*
import kotlinx.android.synthetic.main.select_group_item.view.*

class SelectGroupViewHolder(
    val context: Context, parent: ViewGroup?,
    itemView: View,var checkArray: ArrayList<GroupCheck>
) : RecyclerView.ViewHolder(itemView), CompoundButton.OnCheckedChangeListener {

    val SGI_name = itemView.SGI_name
    val SGI_check = itemView.SGI_check
    val SGI_view = itemView.SGI_view
    var globalposition:Int? = null

    fun onBind(
        item: GroupDto,
        position: Int,
        items: ArrayList<GroupDto>
    ) {
        globalposition = position
        SGI_name.text = item.name

        if (position != items.size - 1) {
            SGI_view.visibility = View.GONE
        }

        SGI_check.setOnCheckedChangeListener(this)
        SGI_check.isChecked = checkArray[position].check
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        globalposition?.let { checkArray[it].check = isChecked }
    }
}