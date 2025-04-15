package com.and.mindeaseapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.and.mindeaseapp.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EBEB)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "MindEase",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(16.dp))
        MentalHealthTestButton(navController = navController)
        Spacer(modifier = Modifier.height(24.dp))
        FeatureIconsRow(navController)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Start Your Day",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxSize()
                .background(
                    Color(0xFF937373),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
        )
    }
}


@Composable
fun ProfileSection() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(Color(0xFF937373), shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(18.dp))
        Column {
            Text("Tom Holland", fontWeight = FontWeight.Bold, fontSize = 26.sp)
            Text("Welcome Back", fontSize = 17.sp, color = Color.Gray)
        }
    }

    Spacer(modifier = Modifier.padding(20.dp))

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
    ) {
        Text("Good Morning", fontWeight = FontWeight.Bold, fontSize = 40.sp)
        Spacer(modifier = Modifier.padding(7.dp))
        Text("How are you feeling today?", fontSize = 23.sp, color = Color.Gray)
    }
}

@Composable
fun MentalHealthTestButton(navController: NavController) {
    Button(
        onClick = { /* Navigate to test */
            navController.navigate("test") {
                popUpTo("home") { inclusive = true }
            }
        },
        colors = ButtonDefaults.buttonColors(Color(0xFF937373)),
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text("Mental Health Test", color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun FeatureIconsRow(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FeatureIcon(
            label = "Doctor Recommendation",
            imageRes = com.and.mindeaseapp.R.drawable.docrec,
            onClick = {
                navController.navigate("doctor") {
                    popUpTo("home") { inclusive = true }
                }
            }
        )

        FeatureIcon(
            label = "Chatbot Support",
            imageRes = com.and.mindeaseapp.R.drawable.chatbot,
            onClick = {
                navController.navigate("chatbot") {
                    popUpTo("home") { inclusive = true }
                }
            }
        )

        FeatureIcon(
            label = "Self-Care Exercise",
            imageRes = com.and.mindeaseapp.R.drawable.selfcare,
            onClick = {
                navController.navigate("exercise") {
                    popUpTo("home") { inclusive = true }
                }
            }
        )

        FeatureIcon(
            label = "Appointment",
            imageRes = R.drawable.breathing,
            onClick = {
                navController.navigate("appointment") {
                    popUpTo("home") { inclusive = true }
                }
            }
        )

    }
}





@Composable
fun FeatureIcon(label: String, imageRes: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(80.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .background(Color(0xFF937373), shape = CircleShape)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = label,
                modifier = Modifier.size(28.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}