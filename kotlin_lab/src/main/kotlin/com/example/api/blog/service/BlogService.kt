package com.example.api.blog.service

import com.example.api.blog.dto.BlogDto
import org.springframework.stereotype.Service

@Service
class BlogService {
    fun searchKakao(blogDto: BlogDto): String? {
        return "SearchKakao"
    }
}