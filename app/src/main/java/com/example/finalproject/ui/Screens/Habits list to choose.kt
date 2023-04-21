package com.example.finalproject.ui.Screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.*
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar


@Composable
fun ScreenHabits (
    modifier: Modifier = Modifier,
    //projectViewModel: ProjectViewModel = viewModel()

    ) {
        
    }


fun TextField(value: Int, onValueChange: () -> Unit) {

}

@Composable
fun UserHabits() {
    val context = LocalContext.current
    val userhabits = remember { mutableStateOf("") }
    val setTime = remember { mutableStateOf(-1) }
    val Alarm_off_on = remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ) {
        TextField(value = userhabits.value, onValueChange = { userhabits.value = it })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = setTime.value, onValueChange = { setTime.value })
        Switch(checked = Alarm_off_on.value, onCheckedChange = {Alarm_off_on.value = it} )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { saveHabitfromUser(
            context,
            userhabits.value,
            setTime.value,
            Alarm_off_on.value) }) {
            Text("Save Habit options")
    }
        Text("Habit is, ${getUserHabit(context) ?: "No habits, Try adding one"}!")
        Text("Time for habit is, ${getUserTime(context) ?: "No time"}!")
        Text("want notify?, ${getUserNotify(context) ?: "false"}!")

    }

}
