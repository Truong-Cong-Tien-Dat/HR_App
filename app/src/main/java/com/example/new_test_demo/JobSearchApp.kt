package com.example.new_test_demo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.new_test_demo.features.hr.jobseeker.JobListScreen
import com.example.new_test_demo.features.hr.jobseeker.MyJobsScreen
import com.example.new_test_demo.profille.ProfileScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun JobSearchApp() {
    val items = listOf(
        BottomNavItem("Home", Icons.Filled.Home),
        BottomNavItem("Job", Icons.Filled.Work),
        BottomNavItem("Chat", Icons.Filled.Chat),
        BottomNavItem("Profile", Icons.Filled.Person)
    )
    var selectedItemIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        },
                        label = {
                            Text(text = item.title)
                        },
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        when (selectedItemIndex) {
            0 -> JobListScreen(modifier = Modifier.padding(innerPadding))
            1 -> MyJobsScreen(modifier = Modifier.padding(innerPadding))
            2 -> Text("Chat Screen", modifier = Modifier.padding(innerPadding))
            3 -> ProfileScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

data class BottomNavItem(
    val title: String,
    val icon: ImageVector
)