package com.example.alpha.data.model

data class Comment(
    val commentId: Int,                // 댓글 ID (고유 식별자)
    val authorId: Int,                 // 댓글 작성자 ID
    val content: String,               // 댓글 내용
    val timestamp: String,             // 댓글 작성 시간
    val likedBy: Set<Int> = emptySet()  // 댓글에 좋아요를 누른 사람들의 ID 집합
)