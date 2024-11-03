package com.example.alpha.schedule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alpha.R
import com.example.alpha.data.model.Schedule
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

@Composable
fun ScheduleCard(
    schedule: Schedule
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(schedule.title, style = MaterialTheme.typography.titleSmall)
                Text(schedule.content, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
@Preview
@Composable
fun ScheduleCardPreview() {
    ScheduleCard(dummySchedules[0])
}

@Preview(showBackground = true)
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen()
}