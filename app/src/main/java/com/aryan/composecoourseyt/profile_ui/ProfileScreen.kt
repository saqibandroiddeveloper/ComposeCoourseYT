package com.aryan.composecoourseyt.profile_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aryan.composecoourseyt.R

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "saqiandroiddev_offcial", modifier = Modifier.padding(10.dp))
        ProfileSection()
        ProfileDescription(
            displayName = "Android Developer",
            description = "3 years of coding experience\n" +
                    "Want me to make your app? visit my portfolio!\n" +
                    "Follow me on linkedin!",
            url = "https://saqib-portfolio-two.vercel.app/",
            followedBy = listOf("Babar", "Rizwan"),
            otherCount = 39
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))

        HighlightSection(
            highlight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    name = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    name = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    name = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    name = "Telegram"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.kmm),
                    name = "KMM"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.multiple_languages),
                    name = "Localize"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.learn_coding_fast),
                    name = "LearnCoding"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    name = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    name = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    name = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    name = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostGrid(
                posts = listOf(
                    painterResource(id = R.drawable.learn_coding_fast),
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.telegram),
                    painterResource(id = R.drawable.discord),
                    painterResource(id = R.drawable.qa),
                    painterResource(id = R.drawable.youtube),
                ),
                modifier = Modifier.fillMaxWidth()
            )

            1 -> PostGrid(
                posts = listOf(
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.telegram),
                    painterResource(id = R.drawable.discord),
                    painterResource(id = R.drawable.qa),
                    painterResource(id = R.drawable.youtube),
                    painterResource(id = R.drawable.learn_coding_fast),
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.intermediate_dev),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notification",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Notification",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            RoundImage(
                painter = painterResource(id = R.drawable.saqi_pic),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun RoundImage(
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = "Image",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )


}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        ProfileStat(numberText = "600", text = "Posts")
        ProfileStat(numberText = "99.9k", text = "Followers")
        ProfileStat(numberText = "69", text = "Followings")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int,
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        Text(
            text = description,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }

                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )

        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            name = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            name = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            name = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    name: String? = null,
    icon: ImageVector? = null,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        name?.let {
            Text(
                text = it,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        icon?.let {
            Icon(imageVector = it, contentDescription = null, tint = Color.Black)
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
) {
    LazyRow(
        modifier = modifier
    ) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(painter = highlight[it].image, modifier = Modifier.size(70.dp))
                Text(
                    text = highlight[it].name,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = Color.Black
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.name,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostGrid(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = "Posts",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White)
            )
        }
    }
}