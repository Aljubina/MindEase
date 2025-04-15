package com.and.mindeaseapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MindEaseNavigationGraph() {
    val navController = rememberNavController()  // Create NavController

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }
        composable("onboarding") { OnboardingScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("test") { MentalHealthTest(navController)}
        composable("doctor") { DoctorRecommendationScreen(navController) }
        composable("appointment") { AppointmentScreen() }
        composable("chatbot") { ChatbotScreen() }
        composable("chatbot") { ChatbotScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("exercise") { SelfCareScreen(navController) }

//        composable("exercise") { SelfCareScreen(navController) }

    }
}

