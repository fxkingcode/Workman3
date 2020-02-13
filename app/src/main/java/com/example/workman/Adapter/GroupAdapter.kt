package com.example.workman.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.workman.Adapter.AdapterContract.GroupAdapterContract
import com.example.workman.Adapter.Holder.GroupViewHolder
import com.example.workman.Adapter.Holder.SelectGroupViewHolder
import com.example.workman.Model.DTO.GroupDto
import com.example.workman.Model.DTO.SelectGroupData
import com.example.workman.R
import kotlin.collections.ArrayList

class GroupAdapter(val context: Context, private val itemType: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), GroupAdapterContract.Model,
    GroupAdapterContract.View, Filterable {

    private var checkArray: ArrayList<SelectGroupData> = ArrayList()//체크 클릭하면 여기에 idx add

    override var onClickFunc: ((Int) -> Unit)? = null

    lateinit var items: ArrayList<GroupDto>
    lateinit var searchArray: ArrayList<GroupDto>

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: GroupDto = searchArray[position]
        when (itemType) {
            0 -> {
                (holder as GroupViewHolder)
                holder.onBind(item, position, searchArray)
            }
            2 -> {
                (holder as SelectGroupViewHolder)
                holder.onBind(item, position, searchArray)
            }
        }
    }

    override fun allCheck(boolean: Boolean) {
        if (boolean) {
            for (i in 0 until items.size) {
                if (!checkArray.contains(SelectGroupData(items[i].idx, items[i].name.toString()))) {
                    checkArray.add(SelectGroupData(items[i].idx, items[i].name.toString()))
                }
            }
        } else {
            checkArray.clear()
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (itemType) {
            0 -> {
                view =
                    LayoutInflater.from(parent.context).inflate(R.layout.group_item, parent, false)
                GroupViewHolder(context, parent, onClickFunc,view)
            }
            2 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.select_group_item, parent, false)
                SelectGroupViewHolder(context, parent, view, checkArray)
            }

            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun getItemCount(): Int = searchArray.size

    override fun notifyAdapter() = notifyDataSetChanged()

    override fun addItems(groupItems: ArrayList<GroupDto>) {
        this.items = groupItems
        this.searchArray = items
    }

    override fun clearItems() {
        if (::items.isInitialized) {
            items.clear()
            searchArray.clear()
        }
    }

    override fun getFilter(): Filter {//필터
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                searchArray = if (charString.isEmpty()) {
                    items
                } else {
                    val filteredList = ArrayList<GroupDto>()
                    //이부분에서 원하는 데이터를 검색할 수 있음
                    for (row in items) {
                        if (row.name?.contains(charString)!!) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = searchArray
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                searchArray = filterResults.values as ArrayList<GroupDto>

                notifyDataSetChanged()
            }
        }
    }

    override fun filter(text: String) {
        filter.filter(text)
    }

    override fun setCheckArray(array: ArrayList<SelectGroupData>) {
        checkArray = array

        notifyDataSetChanged()
    }

    override fun getCheckArray(): ArrayList<SelectGroupData> = checkArray
    override fun getItem(position: Int): GroupDto = searchArray[position]
}