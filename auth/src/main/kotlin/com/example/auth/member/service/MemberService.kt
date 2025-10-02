package com.example.auth.member.service

import com.example.auth.common.authority.JwtTokenProvider
import com.example.auth.common.authority.TokenInfo
import com.example.auth.common.exception.InvalidInputException
import com.example.auth.common.status.CommonConstants
import com.example.auth.common.status.ResultCode
import com.example.auth.common.status.Role
import com.example.auth.member.dto.LoginDto
import com.example.auth.member.dto.MemberDtoRequest
import com.example.auth.member.dto.MemberDtoResponse
import com.example.auth.member.entity.Member
import com.example.auth.member.entity.MemberRole
import com.example.auth.member.repository.MemberRepository
import com.example.auth.member.repository.MemberRoleRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider
){
    /**
     * 회원가입
     */
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        // ID 중복 검사
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            return ResultCode.MEMBER_ALREADY_SIGNUP_ID.msg
        }

        // 사용자 정보 저장
        member = memberDtoRequest.toEntity();
        memberRepository.save(member)

        // 권한 저장
        val memberRole = MemberRole(null, Role.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return ResultCode.MEMBER_SIGNUP_SUCCESS.msg
    }

    /**
     * 로그인
     */
    fun login(loginDto: LoginDto): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.loginId, loginDto.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }

    /**
     * 내 정보 조회
     */
    fun searchMyInfo(id: Long): MemberDtoResponse {
        val member = memberRepository.findByIdOrNull(id)
            ?: throw InvalidInputException("id", "회원번호($id)가 존재하지 않는 유저입니다.")
        return member.toDto()
    }

    /**
     * 내 정보 변경
     */
    fun saveMyInfo(memberDtoRequest: MemberDtoRequest): String {
        val member = memberDtoRequest.toEntity()
        memberRepository.save(member)
        return ResultCode.MEMBER_UPDATE_SUCCESS.msg
    }
}