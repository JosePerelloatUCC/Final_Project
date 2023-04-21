package com.example.finalproject.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FinalProjectUIState (
    val temp:Int = 0
        )

class ProjectViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(FinalProjectUIState())
    val uiState: StateFlow<FinalProjectUIState> = _uiState.asStateFlow()
}


fun saveHabitfromUser(context: Context, name: String, time: Int, notification: Boolean) {
    val habitz = context.getSharedPreferences("user_habits", Context.MODE_PRIVATE)
    habitz.edit().putString("Habit_name", name).apply()
    val settime = context.getSharedPreferences("Time_reminder", Context.MODE_PRIVATE)
    settime.edit().putInt("Time_for_notification", time).apply()
    val  notify = context.getSharedPreferences("Want_reminder?", Context.MODE_PRIVATE)
    notify.edit().putBoolean("Set_reminder", notification).apply()
}

fun getUserHabit(context: Context) : String? {
    val habitz = context.getSharedPreferences("user_habits", Context.MODE_PRIVATE)
    return habitz.getString("Habit_name", null)
}

fun getUserTime(context: Context) : Int? {
    val habitTime = context.getSharedPreferences("Time_reminder", Context.MODE_PRIVATE)
    return habitTime.getInt("Time_for_notification", -1)
}

fun getUserNotify(context: Context) : Boolean? {
    val wantNotify = context.getSharedPreferences("Want_reminder?", Context.MODE_PRIVATE)
    return wantNotify.getBoolean("Set_reminder", false)
}
