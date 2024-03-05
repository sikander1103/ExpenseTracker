package com.example.momo.presentation.splash

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.momo.R
import com.example.momo.coordinators.Screen
import kotlinx.coroutines.delay

@Composable
fun  SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
navController.popBackStack()
      navController.navigate(Screen.OnboardingScreen.route)

    }
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF3E7C78))) {

        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.hellonew))

        val (item)=createRefs()

        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever,    modifier = Modifier.constrainAs(item) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }.size(500.dp))

    }
}