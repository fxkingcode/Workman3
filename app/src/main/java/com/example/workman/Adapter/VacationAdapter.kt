package com.example.workman.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Adapter.Holder.EmployeeVacationViewHolder
import com.example.workman.Adapter.Holder.VacationViewHolder
import com.example.workman.Adapter.Holder.WaitingVacationViewHolder
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R

class VacationAdapter(val context: Context, private val itemType: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    VacationAdapterContract.Model, VacationAdapterContract.View {

    override fun getItem(position: Int): VacationItem = items[position]

    override var onClickFunc: ((Int) -> Unit)? = null

    lateinit var items: ArrayList<VacationItem>

    override fun getItemViewType(position: Int): Int {
        return itemType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: VacationItem = items[position]
        when (itemType) {
            0 -> {
                (holder as VacationViewHolder)
                holder.onBind(item, position)
            }
            1 -> {
                (holder as EmployeeVacationViewHolder)
                holder.onBind(item, position)
            }
            2 -> {
                (holder as WaitingVacationViewHolder)
                holder.onBind(item, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            0 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.vacation_item, parent, false)
                VacationViewHolder(context, parent, onClickFunc, view)
            }
            1 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.employee_vacation_item, parent, false)
                EmployeeVacationViewHolder(context, parent, onClickFunc, view)
            }
            2 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.waiting_vacation_item, parent, false)
                WaitingVacationViewHolder(context, parent, onClickFunc, view)
            }


            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun notifyAdapter() = notifyDataSetChanged()

    override fun addItems(vacationItems: ArrayList<VacationItem>) {
        this.items = vacationItems
    }

    override fun clearItems() {
        items.clear()
    }
}