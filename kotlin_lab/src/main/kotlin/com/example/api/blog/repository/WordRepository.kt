package com.example.api.blog.repository

import com.example.api.blog.entity.WordCount
import org.springframework.data.repository.CrudRepository

interface WordRepository : CrudRepository<WordCount, String> {
    fun findTop10ByOrderByCntDesc(): List<WordCount>
}