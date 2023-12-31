package com.aryan.composecoourseyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class SimpleAnimActvity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val size by animateDpAsState(
                targetValue = sizeState, label = "size",
                animationSpec = spring(
                    Spring.DampingRatioHighBouncy
                )
            )
            //infinite Anim
            val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 2000
                    ),
                    repeatMode = RepeatMode.Reverse
                ), label = "color anim"
            )


            //keyFrame animationSpec
//            keyframes {
//                durationMillis = 5000
//                sizeState at 0 with LinearEasing
//                sizeState * 1.5f at 1000 with FastOutLinearInEasing
//                sizeState * 2f at 5000
//            }
            //tween animationSpec
//            tween(
//                durationMillis = 3000,
//                delayMillis = 300,
//                easing = LinearOutSlowInEasing
//            )
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color)
            ) {
                Button(onClick = {
                    sizeState += 50.dp
                }) {
                    Text(text = "Increase")
                }
            }
        }
    }
}
