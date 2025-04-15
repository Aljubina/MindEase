package com.and.mindeaseapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Correct import
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier // Correct import
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.and.mindeaseapp.data.Doctor
import com.and.mindeaseapp.ui.theme.DoctorViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorRecommendationScreen(navController: NavController) {

    val doctorViewModel : DoctorViewModel = viewModel()
    val doctors = doctorViewModel.sampleDoctors.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recommended Doctors") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding() + 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
        ) {
            items(doctors) { doctor ->
                DoctorCard(doctor = doctor, navController)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun DoctorCard(doctor: Doctor, navController: NavController) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Correct elevation
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(doctor.name, style = MaterialTheme.typography.titleLarge) // Correct typography
            Text(
                doctor.specialization,
                style = MaterialTheme.typography.bodyMedium, // Correct typography
                color = Color.Gray
            )
            Text("Experience: ${doctor.experience} years")
            Text("Rating: ⭐ ${doctor.rating}")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Implement appointment booking logic */
                    navController.navigate("appointment") {
                        popUpTo("doctor") { inclusive = true }
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Book Appointment")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorRecommendationScreenPreview() {
    val navController = rememberNavController()
    DoctorRecommendationScreen(navController)
}