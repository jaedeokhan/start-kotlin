package com.example.auth.common.authority

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean

const val BEARER_HEADER = "Bearer"

class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token = resolveToken(request as HttpServletRequest)
    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")

        return if (StringUtils.hasText(bearerToken) &&
            bearerToken.startsWith(BEARER_HEADER)) {
                bearerToken.substring(BEARER_HEADER.length + 1)
            } else {
                null
            }
    }
}