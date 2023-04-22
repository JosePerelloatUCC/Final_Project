package com.example.finalproject.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.*


data class FinalProjectUIState(
    val habitDescription: String = "",
    val timeofNotification: Int = -1,
    val userNotification: Boolean = false,
    val habitList: MutableList<Habit> = mutableListOf<Habit>()
)

data class Habit(
    val description: String,
    val notificationHour: Int,
    val isNotified: Boolean,
    val userCompleted: List<Date> = listOf()
)

class ProjectViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FinalProjectUIState())
    val uiState: StateFlow<FinalProjectUIState> = _uiState.asStateFlow()

    fun saveHabitfromUser(context: Context, name: String, time: Int, notification: Boolean) {
        val habitz = context.getSharedPreferences("user_habits", Context.MODE_PRIVATE)
        /*habitz.edit().putString("Habit_name", name).apply()
        habitz.edit().putInt("Time_for_notification", time).apply()
        habitz.edit().putBoolean("Set_reminder", notification).apply()*/

        val newHabit = Habit(name, time, notification)
        //add habit to your list of habits
        //save this list into shared preferences
        _uiState.update {
            currentState -> currentState.copy(
            //habitList = currentState.habitList.addAll(newHabit)
            )
        }

        val gson = Gson()
        val json = gson.toJson(newHabit)
        habitz.edit().putString("MyObject", json).apply()
    }

    fun getUserHabit(context: Context): String? {
        val habitz = context.getSharedPreferences("user_habits", Context.MODE_PRIVATE)
        return habitz.getString("Habit_name", null)
    }

    fun getUserTime(context: Context): Int? {
        val habitTime = context.getSharedPreferences("user_habits", Context.MODE_PRIVATE)
        return habitTime.getInt("Time_for_notification", -1)
    }

    fun getUserNotify(context: Context): Boolean? {
        val wantNotify = context.getSharedPreferences("user_habits", Context.MODE_PRIVATE)
        return wantNotify.getBoolean("Set_reminder", false)
    }

    fun onSaveClicked() {

    }
}


