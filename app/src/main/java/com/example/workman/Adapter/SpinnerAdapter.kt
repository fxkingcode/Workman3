package com.example.workman.Adapter

import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.annotation.SuppressLint
import android.widget.TextView
import android.view.LayoutInflater
import android.app.Activity
import android.content.Context
import android.view.View
import com.example.workman.Model.DTO.ColorData
import kotlinx.android.synthetic.main.spinner.view.*


class SpinnerAdapter constructor(var context: Activity,var groupid: Int,var list:ArrayList<ColorData>) :ArrayAdapter<ColorData>(context,groupid,list){
    private var inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = inflater.inflate(groupid, parent, false)
        val spinnerView = itemView.spinnercolor as TextView
        spinnerView.setBackgroundResource(list[position].getcolorId())
        spinnerView.text = list[position].getcolorname()

        return itemView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}