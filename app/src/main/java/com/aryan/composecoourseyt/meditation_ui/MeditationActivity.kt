package com.aryan.composecoourseyt.meditation_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aryan.composecoourseyt.meditation_ui.ui.HomeScreen
import com.aryan.composecoourseyt.meditation_ui.ui.theme.ComposeCoourseYTTheme

class MeditationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoourseYTTheme {
               HomeScreen()
            }
        }
    }
}