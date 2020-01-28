package com.example.workman.Adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Adapter.AdapterContract.VacationAdapterContract
import com.example.workman.Adapter.Holder.VacationViewHolder
import com.example.workman.Data.VacationItem

class VacationAdapter(val context: Context) : RecyclerView.Adapter<VacationViewHolder>(),
    VacationAdapterContract.Model, VacationAdapterContract.View {

    lateinit var items: ArrayList<VacationItem>

    override fun onBindViewHolder(holder: VacationViewHolder, position: Int) {
        items[position].let {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacationViewHolder =
        VacationViewHolder(context,parent)

    override fun getItemCount(): Int = items.size

    override fun notifyAdapter() = notifyDataSetChanged()

    override fun addItems(vacationItems: ArrayList<VacationItem>) {
        this.items = vacationItems
    }

    override fun clearItems() {
        items.clear()
    }
}