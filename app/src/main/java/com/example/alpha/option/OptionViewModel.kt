package com.example.alpha.option

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class UserInfo(
    val Name: String,
    val enter: String,
    val message: String
)

data class OptionUiState(
    val UserInfo: UserInfo = UserInfo("name", "enter", "상태메시지를 추가해 주세요"),
    val Profile: List<String> = emptyList(),
    val PostManagement: List<String> = emptyList(),
    val etc: List<String> = emptyList(),
    val isShowingOptionpage: Boolean = true,
    val currentSelectedInfo: String = "-1"
)

class OptionViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OptionUiState())
    val uiState: StateFlow<OptionUiState> = _uiState
    
    //초기 상태
    init {
        initializeUIState()
    }
    private fun initializeUIState() {
        _uiState.value =
            OptionUiState(
                UserInfo = UserInfo("이성호",
                    "앱동 24-2",
                    "상태메시지를 추가해 주세요"
                ),
                Profile = listOf(
                    "이메일 변경",
                    "내 생일 표시"
                ),
                PostManagement = listOf(
                    "내가 쓴 게시물",
                    "댓글 단 게시물",
                    "좋아요 누른 게시물"
                ),
                etc = listOf(
                    "로그아웃",
                    "문의하기",
                    "탈퇴하기"
                )
            )
    }
    fun updateDetailsScreenStates(menu: String) {
        _uiState.update {
            it.copy(
                currentSelectedInfo = menu,
                isShowingOptionpage = false
            )
        }
    }
    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                isShowingOptionpage = true
            )
        }
    }
}