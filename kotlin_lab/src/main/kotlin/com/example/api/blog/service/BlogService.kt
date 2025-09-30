package com.example.api.blog.service

import com.example.api.blog.constants.ExceptionMsg
import com.example.api.blog.constants.SortType
import com.example.api.blog.dto.BlogDto
import com.example.api.blog.entity.WordCount
import com.example.api.blog.repository.WordRepository
import com.example.api.core.exception.InvalidInputException
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
class BlogService (
    val wordRepository: WordRepository
){

    @Value("\${kakao.api-key}")
    val kakaoApiKey: String = ""

    fun searchKakao(blogDto: BlogDto): String? {

        validateBlog(blogDto)

        val webClient: WebClient = WebClient
            .builder()
            .baseUrl("https://dapi.kakao.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

        val response = webClient
            .get()
            .uri { it.path("/v2/search/blog")
                .queryParam("query", blogDto.query)
                .queryParam("sort", blogDto.sort)
                .queryParam("page", blogDto.page)
                .queryParam("size", blogDto.size)
                .build() }
            .header("Authorization", "KakaoAK $kakaoApiKey")
            .exchangeToMono { response ->
                if (response.statusCode().is2xxSuccessful) {
                    response.bodyToMono(String::class.java)
                } else {
                    response.bodyToMono(String::class.java).flatMap { body ->
                        Mono.error(RuntimeException("Error : ${response.statusCode()}"))
                    }
                }
            }

        var result = response.block()

        saveWord(blogDto)

        return result
    }

    private fun validateBlog(blogDto: BlogDto) {

        val msgList = mutableListOf<ExceptionMsg>()

        if (blogDto.query.trim().isEmpty()) {
            msgList.add(ExceptionMsg.EMPTY_QUERY)
        }

        if (blogDto.sort.trim() !in arrayOf(SortType.ACCURACY.type, SortType.RECENCY.type)) {
            msgList.add(ExceptionMsg.NOT_IN_SORT)
        }

        when {
            blogDto.page < 1 -> msgList.add(ExceptionMsg.LESS_THAN_MIN)
            blogDto.page > 50 -> msgList.add(ExceptionMsg.MORE_THAN_MAX)
        }

        if (msgList.isNotEmpty()) {
            val message = msgList.joinToString { it.msg }
            throw InvalidInputException(message)
        }
    }

    private fun saveWord(blogDto: BlogDto) {
        val lowQuery: String = blogDto.query.lowercase()
        val word: WordCount = wordRepository.findById(lowQuery).orElse(WordCount(lowQuery))
        word.cnt++

        wordRepository.save(word)
    }

    fun searchWordRank(): List<WordCount> = wordRepository.findTop10ByOrderByCntDesc()
}