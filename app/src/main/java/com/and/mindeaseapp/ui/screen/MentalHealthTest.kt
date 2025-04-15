package com.and.mindeaseapp.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MentalHealthTest(navController: NavController) {
    val questions = listOf(
        "Have you been feeling sad, empty, or hopeless most days over the last few weeks?",
        "Have you lost interest or pleasure in activities you used to enjoy?",
        "Do you feel anxious, nervous, or on edge most of the time?",
        "Do you experience sudden mood swings — feeling extremely energetic or irritable at times, then very low?",
        "Do you find it difficult to focus, stay organized, or sit still for long periods?",
        "Do you often feel overwhelmed by repetitive thoughts or the urge to perform certain actions (like checking, counting, or washing)?",
        "Have you ever experienced something very traumatic that still affects you through flashbacks, nightmares, or strong emotional reactions?",
        "Do you hear voices, see things, or believe things that others do not?",
        "Do you sometimes feel disconnected from yourself or the world around you, like things aren't real?",
        "Have you had thoughts of hurting yourself or feeling like life isn’t worth living?"
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    val answers = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        if (currentQuestionIndex < questions.size) {
            Column {
                LinearProgressIndicator(
                    progress = currentQuestionIndex / questions.size.toFloat(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Question ${currentQuestionIndex + 1} of ${questions.size}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = questions[currentQuestionIndex],
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(32.dp))

                listOf("Yes", "No", "Sometimes").forEach { option ->
                    Button(
                        onClick = {
                            answers.add(option)
                            currentQuestionIndex++
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF937373)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(option, color = Color.White)
                    }
                }
            }
        } else {
            SummaryScreen(answers, navController)
        }
    }
}

@Composable
fun SummaryScreen(answers: List<String>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Thanks for completing the check-in!", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Based on your responses, we recommend talking to a mental health professional or exploring our self-help tools.")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { /* Navigate to therapist finder or tools */
            navController.navigate("doctor") {
                popUpTo("test") { inclusive = true }
            }
        }) {
            Text("Recommend Doctors")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MentalHealthTestPreview() {
    val navController = rememberNavController()
    MentalHealthTest(navController)
}
