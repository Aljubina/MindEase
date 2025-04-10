package com.and.mindeaseapp.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.and.mindeaseapp.R
import com.and.mindeaseapp.data.onBoardingPage

@Composable
fun WelcomeScreen(navController: NavController) {
    val pages = listOf(
        onBoardingPage("Welcome to Mental Health App", "Take a quick assessment to evaluate your mental wellbeing", R.drawable.welcomeimage)
    )
    val pagerState = rememberPagerState{pages.size}

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(state = pagerState) { page ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)
            ) {
                Text(pages[page].title, fontSize = 36.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(16.dp))
                Image(painterResource(id = pages[page].imageRes), contentDescription = null)
                Spacer(modifier = Modifier.padding(16.dp))
                Text(pages[page].description, fontSize = 16.sp, textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFF937373)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    onClick = {
                        if (pagerState.currentPage == pages.size - 1) {
                            navController.navigate("onboarding") {
                                popUpTo("welcome") { inclusive = true }
                            }
                        }
                    }) {
                    Text("Next")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController)
}
