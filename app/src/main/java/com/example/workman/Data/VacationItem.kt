package com.example.workman.Data

import java.util.*

data class VacationItem(
    val idx: Int?,
    val type: String,
    val date: Date,
    val approve: Boolean,
    val startTime: String?,
    val endTime: String?,
    val reason: String?,
    val email: String
)//시작 시간과 끝나는 시간은 반차만 선택하므로 null값일 수도 있음