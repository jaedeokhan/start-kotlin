package com.example.auth.member.controller

import com.example.auth.common.authority.TokenInfo
import com.example.auth.common.dto.BaseResponse
import com.example.auth.common.dto.CustomUser
import com.example.auth.member.dto.LoginDto
import com.example.auth.member.dto.MemberDtoRequest
import com.example.auth.member.dto.MemberDtoResponse
import com.example.auth.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMsg: String = memberService.signUp(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): BaseResponse<TokenInfo> {
        val tokenInfo = memberService.login(loginDto)
        return BaseResponse(data = tokenInfo)
    }

    @GetMapping("/info")
    fun searchMyInfo(): BaseResponse<MemberDtoResponse> {
        val userId = getUserIdOfSecurity()
        val member = memberService.searchMyInfo(userId);
        return BaseResponse(data = member)
    }


    @PutMapping("/info")
    fun updateMyInfo(@RequestBody memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val userId = getUserIdOfSecurity()
        memberDtoRequest.id = userId
        val resultMsg: String = memberService.saveMyInfo(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }

    /**
     * 시큐리티 userId 조회
     */
    private fun getUserIdOfSecurity(): Long {
        val userId = (SecurityContextHolder
            .getContext()
            .authentication
            .principal as CustomUser)
            .userId
        return userId
    }


}
