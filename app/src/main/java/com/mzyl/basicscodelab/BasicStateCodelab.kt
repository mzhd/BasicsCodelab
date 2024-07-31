package com.mzyl.basicscodelab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mzyl.basicscodelab.ui.theme.BasicsCodelabTheme

class BasicStateCodelab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 将系统栏配置为透明背景
        // enableEdgeToEdge()
        setContent {
            BasicsCodelabTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
                ) {
                    wellness_screen()
                }
            }
        }
    }
}


@Composable
fun wellness_screen(
    modifier: Modifier = Modifier,
    wellness_viewmodel: WellnessViewModel = viewModel()//自动创建WellnessViewModel
) {
    Column(modifier = modifier) {
        stateful_counter(modifier)
//存放进了viewmodel中
//        val list = remember { //屏幕旋转会丢失状态，但是又不能用rememberSaveable，只能用viewmodel
//            get_wellness_tasks().toMutableStateList()
//        }
        wellness_task_list(
            list = wellness_viewmodel.tasks, onclose_task = { task ->
                wellness_viewmodel.remove(task)
            }, oncheck_task = { task, checked ->
                wellness_viewmodel.change_task_checked(task, checked)
            }, modifier = modifier
        )
    }
}

@Composable
fun water_counter1(
    modifier: Modifier = Modifier
) {
    //remember会在重构activity后丢失状态
//    var count by remember {
//        mutableStateOf(0)
//    }
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            var b_is_show_task by remember {
                mutableStateOf(true)
            }
            if (b_is_show_task) {
//                WellnessTaskItem(task_name = "Have you taken your 15 minute walk today?",
//                    on_close = {
//                        b_is_show_task = false
//                    })
            }
            Text(text = "You've had ${count} glasses.")
        }
        Row(modifier = modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ }, enabled = count < 10
            ) {
                Text(text = "Add one")
            }
            Button(modifier = modifier.padding(start = 8.dp), onClick = { count = 0 }) {
                Text(text = "Clear water count")
            }
        }
    }
}

//@Composable
//fun water_counter(
//    value: State<Int>,//状态提升
//    on_value_change: (Int) -> Unit, modifier: Modifier = Modifier
//) {
////remember会在重构activity后丢失状态
////    var count by remember {
////        mutableStateOf(0)
////    }
////    var count by rememberSaveable {
////        mutableStateOf(0)
////    }
//    Column(modifier = modifier.padding(16.dp)) {
//        if (value.value > 0) {
//            Text(text = "You've had ${value.value} glasses.")
//        }
//        Row(modifier = modifier.padding(top = 8.dp)) {
//            Button(
//                onClick = { on_value_change(value.value + 1) }, enabled = value.value < 10
//            ) {
//                Text(text = "Add one")
//            }
//        }
//    }
//}

@Composable
fun stateful_counter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    stateless_counter(count = count, on_increment = { count++ }, modifier = modifier)

}

@Composable
fun stateless_counter(
    count: Int, on_increment: () -> Unit, modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had ${count} glasses.")
        }
        Row(modifier = modifier.padding(top = 8.dp)) {
            Button(
                onClick = on_increment, enabled = count < 10
            ) {
                Text(text = "Add one")
            }
        }
    }
}