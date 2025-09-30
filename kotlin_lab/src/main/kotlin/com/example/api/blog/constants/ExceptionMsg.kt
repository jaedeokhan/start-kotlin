package com.example.api.blog.constants

enum class ExceptionMsg(val msg: String) {
    EMPTY_QUERY(CommonMsg.EMPTY_QUERY_MSG),
    NOT_IN_SORT(CommonMsg.NOT_IN_SORT_MSG),
    LESS_THAN_MIN(CommonMsg.LESS_THAN_MIN_MSG),
    MORE_THAN_MAX(CommonMsg.MORE_THAN_MAX_MSG)
}