package com.example.finalproject.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.Screens.mainScreen

enum class HabitAppScreens() {
    MAIN_SCREEN,
    CHOOSE_HABITS,
    CHECK_PROGRESS
}

/*@Composable
fun SimpleAppScreens(
    modifier: Modifier = Modifier,
    ProjectViewModel: ProjectViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by ProjectViewModel.uiState.collectAsState()


    NavHost(
        navController = navController,
        startDestination = HabitAppScreens.MAIN_SCREEN.name ,)
    {
        composable(route = HabitAppScreens.MAIN_SCREEN.name) {
            mainScreen(
                onHabitslistButtonClicked = {
                    navController.navigate(HabitAppScreens.CHOOSE_HABITS.name) },
            )
        }
    }
}*/