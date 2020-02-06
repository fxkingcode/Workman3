package com.example.workman.Model.DTO

class ColorData constructor(private var colorid:Int, var colorname:String){

    fun getcolorId(): Int {
        return colorid
    }

    fun getcolorname(): String {
        return colorname
    }
}