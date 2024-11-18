package com.example.alpha.schedule

import ScheduleCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.alpha.data.model.dummySchedules

@Composable
fun ScheduleScreen() {
    val dummies =
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Gray)
    ) {
        Text(text = "달력 위치(임시)")
    }
    LazyColumn {
        items(dummySchedules) { sch ->
            ScheduleCard(sch)
        }
    }
}