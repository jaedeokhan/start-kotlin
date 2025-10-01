package com.example.auth.member.controller

import com.example.auth.common.authority.TokenInfo
import com.example.auth.common.dto.BaseResponse
import com.example.auth.member.dto.LoginDto
import com.example.auth.member.dto.MemberDtoRequest
import com.example.auth.member.dto.MemberDtoResponse
import com.example.auth.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMsg = memberService.signUp(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): BaseResponse<TokenInfo> {
        val tokenInfo = memberService.login(loginDto)
        return BaseResponse(data = tokenInfo)
    }

    @GetMapping("/info/{id}")
    fun searchMyInfo(@PathVariable id: Long): BaseResponse<MemberDtoResponse> {
        val member = memberService.searchMyInfo(id);
        return BaseResponse(data = member)
    }
}
