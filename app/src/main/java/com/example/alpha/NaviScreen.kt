package com.example.alpha

import android.view.WindowInsets
import androidx.annotation.DrawableRes
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.alpha.feed.FeedList
import com.example.alpha.option.OptionScreen

// Bottom Navigation Destinations Enum
enum class BottomNavScreen(val title: String, @DrawableRes val icon: Int) {
    Home("홈", R.drawable.home_vector),
    Calendar("일정", R.drawable.calender_vector),
    Board("게시판", R.drawable.board_vector),
    MyPage("마이페이지", R.drawable.option_vector)
}

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentTitle = BottomNavScreen.values().find { it.name == currentRoute }?.title ?: "홈"
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentTitle, color = Color.White) },
                backgroundColor = colorResource(id = R.color.select_icon),
                elevation = 4.dp,
                modifier = Modifier.statusBarsPadding()
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) {paddingValues ->
        NavigationGraph(navController = navController, contentPadding = paddingValues)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = BottomNavScreen.values()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(),
        backgroundColor = Color.White,
        elevation = 10.dp   //그림자
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier
                            .size(width = 30.dp, height = 30.dp)
                            .padding(top = 8.dp, bottom = 8.dp)
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        fontSize = 14.sp,
                        color = if (currentRoute == screen.name) {
                            colorResource(id = R.color.select_icon)
                        } else {
                            Color.Gray
                        }
                    )
                },
                selected = currentRoute == screen.name,
                selectedContentColor = colorResource(R.color.select_icon),
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
        modifier = Modifier.padding(contentPadding),
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None}
    ) {
        composable(BottomNavScreen.Home.name) {
            ScreenContent("홈 화면")
        }
        composable(BottomNavScreen.Calendar.name) {
            ScreenContent("일정 화면")
        }
        composable(BottomNavScreen.Board.name) {
            FeedList()
        }
        composable(BottomNavScreen.MyPage.name) {
            OptionScreen()
        }
    }
}

@Composable
fun ScreenContent(title: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = title, modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.Center))
    }
}