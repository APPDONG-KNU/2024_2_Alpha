package com.example.alpha

import android.view.WindowInsets
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.alpha.option.OptionScreen

// Bottom Navigation Destinations Enum
enum class BottomNavScreen(val title: String) {
    Home("홈"),
    Calendar("일정"),
    Board("게시판"),
    MyPage("마이페이지")
}

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {paddingValues -> // PaddingValues를 받음
        // paddingValues를 NavigationGraph로 전달
        NavigationGraph(navController = navController, contentPadding = paddingValues)
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = BottomNavScreen.values()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(), // Accompanist로 시스템 네비게이션 바 위로 이동
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 10.dp
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { /* 아이콘 추가 가능 */ },
                label = { Text(screen.title) },
                selected = currentRoute == screen.name,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                onClick = {
                    if (currentRoute != screen.name) {
                        navController.popBackStack() // 현재 화면 제거
                        navController.navigate(screen.name) // 새 화면으로 이동
                    }
                },
            )
        }
    }
}
@Composable
fun NavigationGraph(navController: NavHostController, contentPadding: androidx.compose.foundation.layout.PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreen.Home.name,
        modifier = Modifier.padding(contentPadding)
    ) {
        composable(BottomNavScreen.Home.name) {
            ScreenContent("홈 화면")
        }
        composable(BottomNavScreen.Calendar.name) {
            ScreenContent("일정 화면")
        }
        composable(BottomNavScreen.Board.name) {
            ScreenContent("게시판 화면")
        }
        composable(BottomNavScreen.MyPage.name) {
            OptionScreen ()
        }
    }
}

@Composable
fun ScreenContent(title: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = title, modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.Center))
    }
}