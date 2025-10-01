package com.example.auth.common.status

enum class ResultCode(val msg: String) {
    // common
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생하였습니다."),

    // auth
     INVALID_TOKEN("잘못된 토큰 입니다."),

    // member
    MEMBER_ALREADY_SIGNUP_ID("이미 등록된 ID 입니다."),
    MEMBER_SIGNUP_SUCCESS("회원가입이 완료 되었습니다.")
}