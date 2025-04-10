package com.and.mindeaseapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.and.mindeaseapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Log in or sign up",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(15.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.padding(15.dp))

        Button(
            onClick = { /* Handle Login */ },
            colors = ButtonDefaults.buttonColors(Color(0xFF937373)),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("LOG IN")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "OR",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { /* Handle Google Login */ },
            colors = ButtonDefaults.buttonColors(Color(0xFF937373)),
            modifier = Modifier.fillMaxWidth(),
        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.google_icon),
//                contentDescription = "Google",
//                modifier = Modifier.size(24.dp)
//            )
            Spacer(modifier = Modifier.width(8.dp))

            Text("Continue with Google",color = Color.White, )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Skip for now", color = Color.Gray, modifier = Modifier
            .clickable {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}
