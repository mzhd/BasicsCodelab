package com.mzyl.basicscodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Composable
//fun WellnessTaskItem(
//    task_name: String,
//    checked: Boolean,
//    onclose_task: () -> Unit,
//    oncheck_task: (Boolean) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    //滚出屏幕会丢失
////    var check_state by remember {
////        mutableStateOf(false)
////    }
//
//    //必须移除，否则 会内存泄漏
////    var check_state by rememberSaveable {
////        mutableStateOf(false)
////    }
//
//    WellnessTaskItem(
//        task_name,
//        checked,
//        on_check_change = oncheck_task,
//        on_close = onclose_task,
//        modifier = modifier
//    )
//}

@Composable
fun WellnessTaskItem(
    task_name: String,
    check: Boolean,
    on_check_change: (Boolean) -> Unit,
    on_close: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = task_name, modifier = modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(checked = check, onCheckedChange = on_check_change)
        IconButton(onClick = on_close) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

