package com.example.alpha.schedule

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
@Composable
fun ScheduleEditScreen(
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf(LocalDateTime.now()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("일정 제목") },
            placeholder = { Text("일정 제목을 입력해주세요.") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("일정 장소") },
            placeholder = { Text("일정 장소를 입력해주세요.") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        DateTimePicker(
            dateTime,
            onDateTimeSelected = { dateTime = it }
        )
    }
}

@SuppressLint("NewApi")
@Composable
fun DateTimePicker(
    initialDate: LocalDateTime,
    onDateTimeSelected: (LocalDateTime) -> Unit
) {
    var selectedDate by remember { mutableStateOf(initialDate) }
    val context = LocalContext.current

    // 날짜 선택 다이얼로그
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            selectedDate = selectedDate.withYear(year).withMonth(month + 1).withDayOfMonth(dayOfMonth)

            // 날짜 선택 완료 후 시간 다이얼로그 표시
            TimePickerDialog(
                context,
                { _, hourOfDay, minute ->
                    selectedDate = selectedDate.withHour(hourOfDay).withMinute(minute)
                    onDateTimeSelected(selectedDate)
                },
                selectedDate.hour,
                selectedDate.minute,
                false
            ).show()
        },
        selectedDate.year,
        selectedDate.monthValue - 1,
        selectedDate.dayOfMonth
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    ) {
        TextField(
            value = selectedDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일, hh시 mm분 a")),
            onValueChange = {},
            readOnly = true,
            label = { Text("일정 시작 시간") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { datePickerDialog.show() }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { datePickerDialog.show() }
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun ScheduleEditScreenPreview() {
    ScheduleEditScreen()
}