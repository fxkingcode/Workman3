package com.example.workman.Adapter.Holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData
import kotlinx.android.synthetic.main.select_group_item.view.*

class SelectGroupViewHolder(
    val context: Context, parent: ViewGroup?,
    itemView: View, var checkArray: ArrayList<SelectGroupData>
) : RecyclerView.ViewHolder(itemView), CompoundButton.OnCheckedChangeListener {

    val SGI_name = itemView.SGI_name
    val SGI_check = itemView.SGI_check
    val SGI_view = itemView.SGI_view
    var idx: Int? = null
    var name:String? = null

    fun onBind(
        item: GroupDto,
        position: Int,
        items: ArrayList<GroupDto>
    ) {
        idx = items[position].idx
        name = items[position].name

        SGI_name.text = item.name

        if (position != items.size - 1) {
            SGI_view.visibility = View.GONE
        }

        SGI_check.setOnCheckedChangeListener(this)
        SGI_check.isChecked = checkArray.contains(SelectGroupData(item.idx,item.name.toString()))
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if(isChecked)
        {
            if(!checkArray.contains(idx?.let { name?.let { it1 -> SelectGroupData(it, it1) } }))
            {
                name?.let { idx?.let { it1 -> SelectGroupData(it1, it) } }?.let { checkArray.add(it) }
            }
        }else
        {
            name?.let { idx?.let { it1 -> SelectGroupData(it1, it) } }?.let { checkArray.remove(it) }
        }
    }
}