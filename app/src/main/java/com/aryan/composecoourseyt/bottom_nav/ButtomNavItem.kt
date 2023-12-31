package com.aryan.composecoourseyt.bottom_nav

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class ButtomNavItem(
    val name:String,
    val route:String,
    val icon: ImageVector,
    val badgeCount:Int = 0
)
