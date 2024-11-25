package com.example.alpha.feed

import com.example.alpha.data.model.Comment
import com.example.alpha.data.model.Feed

val dummyFeedList = listOf<Feed>(
    Feed("1", "userId01", "2024.11.04.(월) 20:37", "", "text01"),
    Feed("2", "userId02", "2024.11.04.(월) 20:37", "", "text02"),
    Feed("3", "userId03", "2024.11.04.(월) 20:37", "", "text03"),
    Feed("4", "userId04", "2024.11.04.(월) 20:37", "", "text04"),
    Feed("5", "userId05", "2024.11.04.(월) 20:37", "", "text05"),
    Feed("6", "userId06", "2024.11.04.(월) 20:37", "", "text06"),
    Feed("7", "userId07", "2024.11.04.(월) 20:37", "", "text07"),
    Feed("8", "userId08", "2024.11.04.(월) 20:37", "", "text08"),
)

val dummyFeedDetail = Feed("1", "userId01", "2024.11.04.(월) 20:37", "", "text01")

val dummyCommentList = listOf<Comment>(
    Comment(
        commentId = 1,
        authorId = 101,
        content = "첫 번째 댓글입니다.",
        timestamp = "2023-10-01 10:00",
        likedBy = setOf(201, 202)
    ),
    Comment(
        commentId = 2,
        authorId = 102,
        content = "두 번째 댓글입니다.",
        timestamp = "2023-10-01 10:05",
        likedBy = setOf(203)
    ),
    Comment(
        commentId = 3,
        authorId = 103,
        content = "세 번째 댓글입니다.",
        timestamp = "2023-10-01 10:10",
        likedBy = emptySet()
    )
)



