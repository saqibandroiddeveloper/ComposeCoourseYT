package com.aryan.composecoourseyt.meditation_ui.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aryan.composecoourseyt.R
import com.aryan.composecoourseyt.meditation_ui.ButtonNavyMenuItem
import com.aryan.composecoourseyt.meditation_ui.Feature
import com.aryan.composecoourseyt.meditation_ui.standardQuadFromTo
import com.aryan.composecoourseyt.meditation_ui.ui.theme.DeepBlue
import com.aryan.composecoourseyt.meditation_ui.ui.theme.LightRed
import com.aryan.composecoourseyt.meditation_ui.ui.theme.TextWhite
import com.aryan.composecoourseyt.ui.theme.AquaBlue
import com.aryan.composecoourseyt.ui.theme.Beige1
import com.aryan.composecoourseyt.ui.theme.Beige2
import com.aryan.composecoourseyt.ui.theme.Beige3
import com.aryan.composecoourseyt.ui.theme.BlueViolet1
import com.aryan.composecoourseyt.ui.theme.BlueViolet2
import com.aryan.composecoourseyt.ui.theme.BlueViolet3
import com.aryan.composecoourseyt.ui.theme.ButtonBlue
import com.aryan.composecoourseyt.ui.theme.DarkerButtonBlue
import com.aryan.composecoourseyt.ui.theme.LightGreen1
import com.aryan.composecoourseyt.ui.theme.LightGreen2
import com.aryan.composecoourseyt.ui.theme.LightGreen3
import com.aryan.composecoourseyt.ui.theme.OrangeYellow1
import com.aryan.composecoourseyt.ui.theme.OrangeYellow2
import com.aryan.composecoourseyt.ui.theme.OrangeYellow3

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(
                chips = listOf(
                    "Sweet sleep",
                    "Insomnia",
                    "Depression"
                )
            )
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                )
            )
        }
        BottomMenu(
            menuItems = listOf(
                ButtonNavyMenuItem("Home", R.drawable.ic_home),
                ButtonNavyMenuItem("Meditate", R.drawable.ic_bubble),
                ButtonNavyMenuItem("Sleep", R.drawable.ic_moon),
                ButtonNavyMenuItem("Music", R.drawable.ic_music),
                ButtonNavyMenuItem("Profile", R.drawable.ic_profile)
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun BottomMenu(
    menuItems: List<ButtonNavyMenuItem>,
    modifier: Modifier = Modifier,
    activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveColor: Color = AquaBlue,
    initialItemSelectedIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableIntStateOf(initialItemSelectedIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        menuItems.forEachIndexed { index, buttonNavyMenuItem ->
            BottomMenuItem(
                item = buttonNavyMenuItem,
                isSelected = index == selectedItemIndex,
                activeHighLightColor = activeHighLightColor,
                activeTextColor = activeTextColor,
                inactiveColor = inactiveColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: ButtonNavyMenuItem,
    isSelected: Boolean = false,
    activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveColor: Color = AquaBlue,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveColor
        )

    }
}


@Composable
fun GreetingSection(name: String = "M.Saqib") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Good Morning $name",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite
            )
            Text(
                text = "we wish you have a good day!",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite
            )
            Text(
                text = "Meditation . 3-10 min ",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun FeatureSection(
    features: List<Feature>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(15.dp),
            color = TextWhite
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }

}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumColorPoint1 = Offset(0f, height * 0.3f)
        val mediumColorPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColorPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColorPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColorPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColorPath = Path().apply {
            moveTo(mediumColorPoint1.x, mediumColorPoint1.y)
            standardQuadFromTo(mediumColorPoint1, mediumColorPoint2)
            standardQuadFromTo(mediumColorPoint2, mediumColorPoint3)
            standardQuadFromTo(mediumColorPoint3, mediumColorPoint4)
            standardQuadFromTo(mediumColorPoint4, mediumColorPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100)
            close()
        }
        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier =
            Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColorPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineSmall,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart),
                color = TextWhite
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                modifier = Modifier.align(Alignment.BottomStart),
                tint = TextWhite
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(alignment = Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }

    }
}
