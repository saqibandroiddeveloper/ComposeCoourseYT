package com.aryan.composecoourseyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aryan.composecoourseyt.ui.theme.ComposeCoourseYTTheme

class MultiSelectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoourseYTTheme {
                 var items by remember {
                     mutableStateOf(
                         (1..20).map {
                             ItemList(
                                 "item $it",
                                 isSelected = false
                             )
                         }
                     )
                 }
                 LazyColumn(
                     modifier = Modifier.fillMaxSize()
                 ){
                     items(items.size){index ->  
                         Row (
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .clickable {
                             items = items.mapIndexed { i, itemList ->
                                    if (index==i){
                                        itemList.copy(isSelected = !itemList.isSelected)
                                    }else itemList
                             }
                                 }
                                 .padding(16.dp),
                             horizontalArrangement = Arrangement.SpaceBetween,
                             verticalAlignment = Alignment.CenterVertically
                         ){
                           Text(text = items[index].title)
                             if (items[index].isSelected){
                                 Icon(
                                     imageVector = Icons.Default.Check ,
                                     contentDescription = "Selected",
                                     tint = Color.Green,
                                     modifier = Modifier.size(20.dp)
                                 )
                             }
                         }
                     }
                 }
                
            }
        }
    }

    data class ItemList(
        val title:String,
        val isSelected:Boolean
    )
}
