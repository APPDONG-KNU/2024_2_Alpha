package com.example.alpha.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
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
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircleAvatar()
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("김무성", fontWeight = FontWeight.Bold)
                    Text("2024.09.28 (토) 22:50", fontSize = 12.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* TODO: Handle click */ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "더보기 옵션")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "안드로이드는 구글(Google)에서 개발한 운영체제로, 주로 스마트폰과 태블릿에서 사용됩니다. 리눅스 커널을 기반으로 하며...",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_image_24),
                contentDescription = "Android Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconButton(onClick = { /* TODO: Handle like */ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "좋아요")
                    }
                    Text("좋아요")
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /* TODO: Handle comment */ }) {
                        Icon(Icons.Default.Comment, contentDescription = "댓글 달기")
                    }
                    Text("댓글 달기")
                }
            }
        }
    }
}

@Composable
fun CircleAvatar() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(Color.Gray, shape = CircleShape)
    )
}