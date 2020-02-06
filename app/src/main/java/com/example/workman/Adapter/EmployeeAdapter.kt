package com.example.workman.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Adapter.AdapterContract.EmployeeAdapterContract
import com.example.workman.Adapter.Holder.EmployeeViewHolder
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.R
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class EmployeeAdapter(val context: Context, private val itemType: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), EmployeeAdapterContract.Model,
    EmployeeAdapterContract.View {

    override fun getItem(position: Int): EmployeeDto = items[position]

    override var onClickFunc: ((Int) -> Unit)? = null

    lateinit var items: ArrayList<EmployeeDto>

    override fun getItemViewType(position: Int): Int {
        return itemType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: EmployeeDto = items[position]
        when (itemType) {
            0 -> {
                (holder as EmployeeViewHolder)
                holder.onActiveBind(item, position, items)
            }
            1 -> {
                (holder as EmployeeViewHolder)
                holder.onPassiveBind(item, position, items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        return EmployeeViewHolder(context, parent, onClickFunc, view)
    }

    override fun getItemCount(): Int = items.size

    override fun notifyAdapter() = notifyDataSetChanged()

    override fun addItems(employeeItems: ArrayList<EmployeeDto>) {
        this.items = employeeItems
        Collections.sort(items, sort)
    }

    override fun clearItems() {
        if(::items.isInitialized)
        {
            items.clear()
        }
    }

    //정렬
    private val sort: Comparator<EmployeeDto> =
        Comparator<EmployeeDto> { o1, o2 ->
            var o1class: Int = when (o1.position) {
                "최고 관리자" -> 0
                "중간 관리자" -> 1
                "직원" -> 2
                "임시 직원" -> 3
                else -> throw RuntimeException("알 수 없는 포지션 에러")
            }

            var o2class: Int = when (o2.position) {
                "최고 관리자" -> 0
                "중간 관리자" -> 1
                "직원" -> 2
                "임시 직원" -> 3
                else -> throw RuntimeException("알 수 없는 포지션 에러")
            }

            return@Comparator when {
                o1class > o2class -> 1
                o1class == o2class -> 0
                else -> -1
            }
        }
}