package com.example.auth.member.service

import com.example.auth.common.status.ResultCode
import com.example.auth.member.dto.MemberDtoRequest
import com.example.auth.member.entity.Member
import com.example.auth.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository
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

        member = memberDtoRequest.toEntity();
        memberRepository.save(member)

        return ResultCode.MEMBER_SIGNUP_SUCCESS.msg
    }
}