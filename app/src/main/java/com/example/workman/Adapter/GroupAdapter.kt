package com.example.workman.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Adapter.Holder.EmployeeVacationViewHolder
import com.example.workman.Adapter.Holder.SelectGroupViewHolder
import com.example.workman.Adapter.Holder.VacationViewHolder
import com.example.workman.Adapter.Holder.WaitingVacationViewHolder
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.GroupCheck
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R
import java.util.*
import kotlin.collections.ArrayList

class GroupAdapter(val context: Context, private val itemType: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), GroupAdapterContract.Model,
    GroupAdapterContract.View {

    private var checkArray: ArrayList<GroupCheck> = ArrayList()

    override var onClickFunc: ((Int) -> Unit)? = null

    lateinit var items: ArrayList<GroupDto>

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: GroupDto = items[position]
        when (itemType) {
            2 -> {
                (holder as SelectGroupViewHolder)
                holder.onBind(item, position, items)
            }
        }
    }

    override fun allCheck(boolean: Boolean) {
        for(i in 0 until checkArray.size)
        {
            checkArray[i].check = boolean
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (itemType) {
            2 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.select_group_item, parent, false)
                SelectGroupViewHolder(context, parent, view,checkArray)
            }

            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun notifyAdapter() = notifyDataSetChanged()

    override fun addItems(groupItems: ArrayList<GroupDto>) {
        this.items = groupItems
        if(itemType == 2)
        {
            for(i in 0 until items.size)
            {
                checkArray.add(GroupCheck(items[i].idx,false))
            }
        }
    }

    override fun clearItems() {
        if (::items.isInitialized) {
            items.clear()
        }
    }

    override fun getCheckArray(): ArrayList<GroupCheck> = checkArray
    override fun getItem(position: Int): GroupDto = items[position]
}