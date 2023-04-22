package com.example.finalproject.ui.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.*


@Composable
fun ScreenHabits(
    modifier: Modifier = Modifier,
    //projectViewModel: ProjectViewModel = viewModel()

) {

}




@Composable
fun ChooseHabits(
    userhabit:String,
    notificationTime:Int,
    userAlarm:Boolean,
    onSaveClick:() -> Unit
) {
    val context = LocalContext.current

    /*var thisHabit: String = ""
    var thisNotificationTime: String = ""
    var thisNotify: Boolean = false

     */

    var descriptionText by remember {
        mutableStateOf("")
    }

    var timeText by remember {
        mutableStateOf("")
    }

    var notify by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = descriptionText, onValueChange = { descriptionText = it })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = timeText, onValueChange = { timeText = it })
        Switch(checked = notify, onCheckedChange = { notify = it })
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick =  {
            saveHabitfromUser(
                context,
                descriptionText,
                timeText.toInt(),
                notify
            )
        }) {
            Text("Save Habit options")
        }
        Text("Habit is, ${getUserHabit(context) ?: "No habits, Try adding one"}!")
        Text("Time for habit is, ${getUserTime(context) ?: "No time"}!")
        Text("want notify?, ${getUserNotify(context) ?: "false"}!")

    }

}
