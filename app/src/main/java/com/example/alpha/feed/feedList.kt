package com.example.alpha.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alpha.R

@Preview(showBackground = true)
@Composable
fun FeedList() {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Color.Gray)
    ) {
        items(20) { index ->
            ListItem(index)
        }
    }
}

@Composable
fun ListItem(index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp, 8.dp, 8.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically) {
                CircleAvatar()
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("김무성", fontWeight = FontWeight.Bold) // TODO 이름 데이터
                    Text("2024.09.28 (토) 22:50", fontSize = 12.sp, color = Color.Gray) // TODO 날짜 데이터
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
                text = "안드로이드는 구글(Google)에서 개발한 운영체제로, 주로 스마트폰과 태블릿에서 사용됩니다. 리눅스 커널을 기반으로 하며...",
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

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = "좋아요",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                // TODO: Handle like
                            }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("좋아요")
                }
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_comment_24),
                        contentDescription = "댓글 달기",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                // TODO: Handle like
                            }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("댓글 달기")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CircleAvatar() {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Color.Gray, shape = CircleShape)
    )
}