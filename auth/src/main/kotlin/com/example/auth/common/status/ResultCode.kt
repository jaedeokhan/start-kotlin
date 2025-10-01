package com.example.auth.common.status

enum class ResultCode(val msg: String) {
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생하였습니다."),
    MEMBER_ALREADY_SIGNUP_ID("이미 등록된 ID 입니다."),
    MEMBER_SIGNUP_SUCCESS("회원가입이 완료 되었습니다.")
}