package com.example.auth

import com.example.auth.member.dto.LoginDto
import com.example.auth.member.dto.MemberDtoRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@TestPropertySource(properties = ["jwt.secret=DadFufN4Oui8Bfv3ScFj6R9fyJ9hD45E6AGFsXgFsRhT4YSdSb"])
@AutoConfigureMockMvc
class AuthApplicationTests @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun `POST 회원가입 요청 시 200 응답`() {
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
                jsonPath("$.resultCode") { value("SUCCESS")}
            }
    }

    fun requestLogin(loginDto: LoginDto): String {
        var json = objectMapper.writeValueAsString(loginDto)

        var result = mockMvc.post("/api/member/login") {
            contentType = MediaType.APPLICATION_JSON
            content = json
        }
            .andExpect {
                status { is2xxSuccessful() }
                jsonPath("$.resultCode") { value("SUCCESS")}
            }.andReturn()

        return result.response.contentAsString
    }

    @Test
    fun `POST 로그인 시 200 응답`() {
        `POST 회원가입 요청 시 200 응답`()

        val request = LoginDto(
            _loginId = "hjaedeok",
            _password = "test!1234"
        )

        requestLogin(request)
    }

    @Test
    fun `POST 내 정보 조회 200 응답`() {
        `POST 회원가입 요청 시 200 응답`()

        val request = LoginDto(
            _loginId = "hjaedeok",
            _password = "test!1234"
        )

        val response = requestLogin(request)
        val accessToken: String = objectMapper.readTree(response)
            .get("data").get("accessToken").asText()

        mockMvc.get("/api/member/info") {
            header("Authorization", "Bearer $accessToken")
        }
            .andExpect {
                status { is2xxSuccessful() }
                jsonPath("$.data.loginId") { value("hjaedeok",)}
            }
    }
}
