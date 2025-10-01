package com.example.auth.member.repository

import com.example.auth.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>{
    fun findByLoginId(loginId: String): Member?
}