package com.example.workman.Model.DTO

data class GroupDto(
    val idx: Int,
    val name: String?,
    val marker:String?,
    val memo:String?,
    var employees:ArrayList<String>?
)