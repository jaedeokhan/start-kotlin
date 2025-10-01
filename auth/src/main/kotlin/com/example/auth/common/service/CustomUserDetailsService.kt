package com.example.auth.common.service

import com.example.auth.common.status.CommonConstants
import com.example.auth.common.status.ResultCode
import com.example.auth.member.entity.Member
import com.example.auth.member.repository.MemberRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        memberRepository.findByLoginId(username)
            ?.let { createUserDetails(it) }
            ?: throw UsernameNotFoundException(ResultCode.USERNAME_NOT_FOUND.msg)

    private fun createUserDetails(member: Member): UserDetails =
        User(
            member.loginId,
            passwordEncoder.encode(member.password),
            member.memberRole!!.map {
                SimpleGrantedAuthority("${CommonConstants.ROLE_PREFIX}_${it.role}")
            },
        )
}