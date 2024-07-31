package com.mzyl.basicscodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun wellness_task_list(
    list: List<WellnessTask>,
    onclose_task: (WellnessTask) -> Unit,
    oncheck_task: (WellnessTask, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(list, key = { item ->
            item.id
        }) { item ->
            WellnessTaskItem(task_name = item.id.toString(), check = item.checked, on_close = {
                onclose_task(item)
            }, on_check_change = { checked ->
                oncheck_task(item, checked)
            }, modifier = modifier
            )
        }
    }
}