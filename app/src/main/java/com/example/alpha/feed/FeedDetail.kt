package com.example.alpha.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alpha.R
import com.example.alpha.data.model.Comment
import com.example.alpha.data.model.Feed

@Preview(showBackground = true)
@Composable
fun FeedDetail() {
    val feed = remember { dummyFeedDetail }
    val commentList = remember { dummyCommentList }

    Column {
        Feed(feed)
        CommentList(commentList)
    }
}

@Composable
fun Feed(feed : Feed) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleAvatar()
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(feed.userId ?: "알 수 없음", fontWeight = FontWeight.Bold) // TODO 이름 데이터
            Text(feed.date ?: "알 수 없음", fontSize = 12.sp, color = Color.Gray) // TODO 날짜 데이터
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.baseline_more_horiz_24),
            contentDescription = "더보기 옵션",
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Top)
                .clickable {
                    // TODO 클릭 이벤트
                }
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = feed.text ?: "",
        fontSize = 14.sp,
        modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        val imageSize = maxWidth.coerceAtMost(maxHeight)
        Image(
            painter = painterResource(id = R.drawable.baseline_image_24), // TODO 이미지 데이터
            contentDescription = "Image",
            modifier = Modifier
                .size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun CommentList(commentList : List<Comment>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(commentList) { comment ->
            CommentListItem(comment)
        }
    }
}

@Composable
fun CommentListItem(comment: Comment) {

}
