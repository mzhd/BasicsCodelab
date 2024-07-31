package com.mzyl.basicscodelab

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//data class WellnessTask(
//    val id: Int, val label: String, var b_is_checked: MutableState<Boolean> = mutableStateOf(false)
//)

class WellnessTask(
    val id: Int, val label: String,
    initial_checked: Boolean = false
) {
    var checked by mutableStateOf(initial_checked)
}