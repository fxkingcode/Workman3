package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.ColorData
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData
import com.example.workman.R
import kotlinx.android.synthetic.main.group_item.view.*
import kotlinx.android.synthetic.main.select_group_item.view.*
import android.graphics.drawable.GradientDrawable
import android.graphics.Color
import androidx.core.content.ContextCompat


class GroupViewHolder(
    val context: Context, parent: ViewGroup?,
    val listenerFunc: ((Int) -> Unit)?,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    val GI_name = itemView.GI_name
    val GI_maker = itemView.GI_maker
    val GI_personnel = itemView.GI_personnel
    val GI_view = itemView.GI_view

    fun onBind(
        item: GroupDto,
        position: Int,
        items: ArrayList<GroupDto>
    ) {
        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }

        GI_name.text = item.name
        val bgShape = GI_maker.background as GradientDrawable
        when(item.marker)
        {
            "검정색" -> bgShape.setColor(ContextCompat.getColor(context,R.color.black))
            "파란색" -> bgShape.setColor(ContextCompat.getColor(context,R.color.blue))
            "빨간색" -> bgShape.setColor(ContextCompat.getColor(context,R.color.red))
            "초록색" -> bgShape.setColor(ContextCompat.getColor(context,R.color.green))
            "회색" -> bgShape.setColor(ContextCompat.getColor(context,R.color.gray))
            "민트색" -> bgShape.setColor(ContextCompat.getColor(context,R.color.mint))
        }

        GI_personnel.text = item.employees?.size.toString()

        if (position != items.size - 1) {
            GI_view.visibility = View.GONE
        }
    }
}