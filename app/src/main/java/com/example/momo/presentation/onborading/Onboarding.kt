package com.example.momo.presentation.onborading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.momo.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import kotlin.math.roundToInt

@Composable
fun OnboardingScreen(navController: NavController) {
   ConstraintLayout(modifier = Modifier
       .fillMaxSize()
       .background(Color.White)) {
       val(item1,item2,item3,item4,item5,item6,item7)=createRefs()
       val scale = remember { Animatable(1f) }

       val offsetAnimation = remember { Animatable(-70f) }


       LaunchedEffect(Unit) {
           offsetAnimation.animateTo(
               targetValue = -0f,
               animationSpec = infiniteRepeatable(
                   animation = tween(durationMillis = 1000, easing = LinearEasing),
                   repeatMode = RepeatMode.Reverse
               )
           )
       }

       Box(modifier = Modifier
           .constrainAs(item1) {
               top.linkTo(parent.top)
               start.linkTo(parent.start)
               end.linkTo(parent.end)
           }
           .fillMaxWidth()
           .height(414.sdp)) {
    Image(painter = painterResource(id = R.drawable.onboradingbgvector), contentDescription ="onboarding backgroung vector", contentScale = ContentScale.FillBounds  )
}
       Image(painter = painterResource(id = R.drawable.humanvector), contentDescription ="onboarding human vector" , modifier = Modifier
           .constrainAs(item2) {
               bottom.linkTo(item1.bottom)
           }
           .fillMaxWidth(),)
       Image(painter = painterResource(id = R.drawable.coint), contentDescription ="onboarding human vector" , modifier = Modifier
           .constrainAs(item3) {
               start.linkTo(item2.start, margin = 50.dp)
               top.linkTo(item2.top, margin = 5.dp)
           }
           .size(70.sdp)
           .graphicsLayer {
               scaleX = scale.value
               scaleY = scale.value
           }
           .offset {
               IntOffset(0, offsetAnimation.value.roundToInt())
           }
           )
       Image(painter = painterResource(id = R.drawable.donut), contentDescription ="onboarding human vector" , modifier = Modifier
           .constrainAs(item4) {
               end.linkTo(item2.end, margin = 50.dp)
               top.linkTo(item2.top, margin = 50.dp)
           }
           .size(70.sdp)
           .offset {
               IntOffset(0, offsetAnimation.value.roundToInt())
           }
       )
       Text(text = stringResource(R.string.spend_smarter_save_more) ,   style = TextStyle(
           color = Color(0xFF438883),
           fontSize = 30.ssp,
           fontWeight = FontWeight.ExtraBold,
           fontFamily = FontFamily(Font(R.font.interregular)),
           textAlign = TextAlign.Center,
           letterSpacing = 0.ssp
       ),
       modifier = Modifier.constrainAs(item5
       ){
                          start.linkTo(parent.start)
               end.linkTo(parent.end)
               top.linkTo(item2.bottom)

       }
       )

       Card(
           modifier = Modifier
               .constrainAs(item6) {
                   start.linkTo(parent.start)
                   end.linkTo(parent.end)
                   top.linkTo(item5.bottom, margin = 17.dp)
               }
               .padding(10.sdp),
           elevation = CardDefaults.cardElevation(
               defaultElevation = 10.sdp
           )
       ) {
           Box(modifier = Modifier
               .fillMaxWidth()
               .background(Color(0xFF3E7C78))
               .height(40.sdp)
               .clickable {

               },

               contentAlignment = Alignment.Center
               ) {

               Text(
                   text = stringResource(R.string.get_started),
                   modifier = Modifier.padding(7.dp),
                   style = TextStyle(
                       fontFamily = FontFamily(Font(R.font.interregular)),
                       color = Color.White,
                      fontWeight = FontWeight.SemiBold,
                       fontSize = 18.ssp
                   )
               )
           }
       }
       Text(
           text = "Already Have Account? Login",
           modifier = Modifier.constrainAs(item7){
               top.linkTo(item6.bottom)
               start.linkTo(parent.start)
               end.linkTo(parent.end)
               bottom.linkTo(parent.bottom)

           }.padding(7.sdp),
           style = TextStyle(
               fontFamily = FontFamily(Font(R.font.interregular)),
               color = Color(0xff444444),
               fontSize = 14.ssp
           )
       )


   }



}