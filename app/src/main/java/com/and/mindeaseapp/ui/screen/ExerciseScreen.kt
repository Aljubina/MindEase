package com.and.mindeaseapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.and.mindeaseapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen(exercise: SelfCareExercise, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${exercise.title} Video") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Placeholder: Replace with actual VideoPlayer later
            Image(
                painter = painterResource(id = exercise.imageResId),
                contentDescription = "Video placeholder",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "This would be the video player screen for: ${exercise.title}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun ExerciseScreenPreview() {
    val navController = rememberNavController()
    val sampleExercise = SelfCareExercise(
        title = "Sample Exercise",
        description = "This is a sample exercise for preview.",
        imageResId = R.drawable.yoga // Replace with an actual image resource ID
    )
    ExerciseScreen(exercise = sampleExercise, navController = navController)
}