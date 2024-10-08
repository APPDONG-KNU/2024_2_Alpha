package com.example.alpha.option

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alpha.R
import com.example.alpha.ui.theme.TextStyles


@Preview(showBackground = true)
@Composable
fun List_btnPreview() {
    Column {
        Info(name = "이성호", enter = "앱동 24-2")
        Spacer(modifier = Modifier.height(16.dp))
        ListButton(name = "프로필", items = Profile)
        Spacer(modifier = Modifier.height(16.dp))
        ListButton(name = "내가 쓴 게시물", items = PostManagement)
        Spacer(modifier = Modifier.height(16.dp))
        ListButton(name = "기타", items = etc)

    }
}

@Composable
fun OptionButton(name: String, modifier: Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(0.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background, // 배경색을 primary로 설정
                contentColor = MaterialTheme.colorScheme.onBackground // 텍스트 색상도 설정
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp)
                    .weight(1f)
            ) {
                Text(
                    text = name,
                    modifier = Modifier
                        .align(Alignment.CenterVertically) // 세로 정렬은 가운데
                        .padding(start = 16.dp), // 왼쪽 끝에서 16dp 떨어진 위치
                    style = TextStyles.MiddleText
                )
            }
            Row(modifier
                .padding(end = 24.dp)
                .weight(1f),
                horizontalArrangement = Arrangement.End // 오른쪽 정렬
            ){
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null, // 이미지 설명
                    modifier = Modifier
                        .size(16.dp) // 이미지 크기 설정
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun UnderlinedColumn(content: @Composable () -> Unit) {
    val underlineColor = colorResource(id = R.color.under_line)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 2f
                val padding = 8.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = underlineColor,
                    start = Offset(padding, y),
                    end = Offset(size.width - padding, y),
                    strokeWidth = strokeWidth
                )
            }
    ) {
        content()
    }
}

@Composable
fun ListButton(name : String, items: List<String>, modifier: Modifier = Modifier){
    Column(){
        UnderlinedColumn {
            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 3.dp),
                style = TextStyles.LargeText
            )
        }
        UnderlinedColumn{
            items.forEach { item ->
                OptionButton(name = item, modifier = Modifier)
            }
            Spacer(modifier = Modifier.height(1.dp)) // 하단에 공간 확보
        }
    }

}

val Profile = listOf(
    "이메일 변경",
    "내 생일 표시"
)
val PostManagement = listOf(
    "내가 쓴 게시물",
    "댓글 단 게시물",
    "좋아요 누른 게시물"
)
val etc = listOf(
    "로그아웃",
    "문의하기",
    "탈퇴하기"
)

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 16.sp, // 글자 크기 설정
            color = Color.Black // 글자 색상 설정
        ),
        modifier = modifier,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp) // 텍스트와 아래선 간격 조정
                    .drawBehind {
                        val strokeWidth = 1.dp.toPx() // 테두리 두께를 픽셀로 변환
                        val y = size.height - strokeWidth / 2
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, y), // 시작 좌표 (왼쪽 아래)
                            end = Offset(size.width, y), // 끝 좌표 (오른쪽 아래)
                            strokeWidth = strokeWidth // 테두리 두께
                        )
                    }
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = "상태메시지를 추가해 주세요",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    )
                }
                innerTextField() // 실제 텍스트 필드가 여기에 들어감
            }
        }
    )
}

@Composable
fun Info(name : String, enter : String){
    var textState by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(start = 16.dp)
    ){
        Box(
            modifier = Modifier
                .size(100.dp) // 원하는 크기의 원형
                .clip(CircleShape)  // 원형으로 클립
                .background(Color.LightGray) // 배경색 설정
        ) {
            Image(
                painter = painterResource(id = R.drawable.person_icon),
                contentDescription = null, // 이미지 설명
                modifier = Modifier
                    .fillMaxSize()  // 이미지가 원형을 꽉 채우도록 설정
                    .padding(top = 5.dp)
            )
        }
        Column (
            modifier = Modifier
                .padding(start = 24.dp, top = 8.dp)
                .fillMaxWidth()

        ){
            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyles.LargeText
            )
            Text(
                text = enter,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyles.SmallText
            )
            CustomTextField(
                value = textState,
                onValueChange = { newValue ->
                    textState = newValue // 사용자가 입력한 값을 상태에 반영
                },
                modifier = Modifier.width(250.dp).padding(top = 8.dp)
            )
        }
    }
}
