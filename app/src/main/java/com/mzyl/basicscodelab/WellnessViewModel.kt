package com.mzyl.basicscodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

fun get_wellness_tasks() = List(30) { index ->
    WellnessTask(index, "Task $index")
}

class WellnessViewModel : ViewModel() {
    private val _tasks = get_wellness_tasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun change_task_checked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}