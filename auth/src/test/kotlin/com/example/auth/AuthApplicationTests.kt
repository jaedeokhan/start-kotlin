package com.example.auth

import com.example.auth.member.controller.MemberController
import com.example.auth.member.dto.MemberDtoRequest
import com.example.auth.member.service.MemberService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class AuthApplicationTests @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun `POST member 요청 시 200 응답`() {
        val request = MemberDtoRequest(
            id = null,
            _loginId = "hjaedeok",
            _name = "deok",
            _password = "test!1234",
            _email = "test@gmail.com",
            _gender = "MAN",
            _birthDate = "2025-10-01"
        )
        val json = objectMapper.writeValueAsString(request)

        mockMvc.post("/api/member/signup") {
            contentType = MediaType.APPLICATION_JSON
            content = json
        }
            .andExpect {
                status { is2xxSuccessful() }
            }
    }
}
