package com.example.alpha.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alpha.data.model.Schedule
import com.example.alpha.data.model.dummySchedules

@Composable
fun ScheduleEditScreen(
    modifier: Modifier = Modifier,
    schedule: Schedule
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            label = { Text(text = "일정 제목") },
            value = schedule.title,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        TextField(
            label = { Text(text = "일정 장소") },
            value = schedule.location,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScheduleEditScreenPreview() {
    ScheduleEditScreen(schedule = dummySchedules.first())
}