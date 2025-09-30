package com.example.api.blog.dto

import com.example.api.blog.constants.CommonMsg
import com.example.api.blog.constants.SortType
import com.example.api.core.annotation.ValidEnum
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class BlogDto (
    @field:NotBlank(message = CommonMsg.EMPTY_QUERY_MSG)
    @JsonProperty("query")
    private val _query: String?,

    @field:NotBlank(message = CommonMsg.NOT_IN_SORT_MSG)
    @field:ValidEnum(enumClass = SortType::class, message = CommonMsg.NOT_IN_SORT_MSG)
    @JsonProperty("sort")
    private val _sort: String?,

    @field:NotNull(message = CommonMsg.PAGE_PARAM_REQUIRED_MSG)
    @field:Max(50, message = CommonMsg.MORE_THAN_MAX_MSG)
    @field:Min(1, message = CommonMsg.LESS_THAN_MIN_MSG)
    @JsonProperty("page")
    private val _page: Int?,

    @field:NotNull(message = CommonMsg.SIZE_PARAM_REQUIRED_MSG)
    @JsonProperty("size")
    private val _size: Int?
) {
    val query: String
        get() = _query!!
    val sort: String
        get() = _sort!!
    val page: Int
        get() = _page!!
    val size: Int
        get() = _size!!
}