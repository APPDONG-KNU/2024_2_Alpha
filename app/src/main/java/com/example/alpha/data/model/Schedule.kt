package com.example.alpha.data.model

val dummySchedules = listOf(
    Schedule(
        id = 1,
        authorId = "ijh1298",
        title = "테스트 제목",
        date = "2024.10.08",
        startTime = "2024.10.09 10AM",
        location = "동아리방",
        content = "테스트용"
    )
)

data class Schedule(
    val id: Int,
    val authorId: String,
    val title: String,
    val date: String,
    val startTime: String,
    val location: String,
    val imageList: List<String> = emptyList(),
    val content: String,
    val likedBy: List<Int> = emptyList(),
    val comments: List<Comment> = emptyList(),
    val participants: List<Int> = emptyList()
)
