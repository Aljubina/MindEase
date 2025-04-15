package com.and.mindeaseapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.and.mindeaseapp.R


data class SelfCareExercise(
    val title: String,
    val description: String,
    val imageResId: Int
)

val selfCareList = listOf(
    SelfCareExercise("Breathing Exercise", "Calm your mind with deep breathing", R.drawable.meditation),
    SelfCareExercise("5-Minute Meditation", "A short session to center yourself", R.drawable.yoga),
    SelfCareExercise("Gratitude Journal", "Write down what you're thankful for", R.drawable.journal),
//    SelfCareExercise("Daily Affirmation", "Start your day with positivity", R.drawable.affirmation),
//    SelfCareExercise("Progress Tracker", "Reflect on how far you've come", R.drawable.tracker)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelfCareScreen(navController: NavController? = null) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Self-Care Exercises") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController?.navigate("home") {
                            popUpTo("exercise") { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(selfCareList) { item ->
                ExerciseCard(
                    exercise = item,
                    onClick = {
                        // Handle detail screen navigation
                    },
                    onWatchClick = {
                        // Handle video screen navigation
                    }
                )
            }

        }
    }
}

@Composable
fun ExerciseCard(exercise: SelfCareExercise, onClick: () -> Unit, onWatchClick: () -> Unit = {}) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = exercise.imageResId),
                contentDescription = exercise.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Dark overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
            )

            // Text and Button
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = onWatchClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.8f)),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text("Watch Video", color = MaterialTheme.colorScheme.primary)
                    }
                }

                Column {
                    Text(
                        text = exercise.title,
                        fontSize = 20.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = exercise.description,
                        fontSize = 14.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SelfCareScreenPreview() {
    val navController = rememberNavController()
    SelfCareScreen(navController)
}

