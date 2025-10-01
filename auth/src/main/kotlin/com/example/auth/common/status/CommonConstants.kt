package com.example.auth.common.status

object CommonConstants {
    // token
    const val EXPIRATION_MILLISECONDS: Long = 1000 * 60 * 60 * 12
    const val BEARER_PREFIX = "Bearer"
    const val AUTHORIZATION_HEADER = "Authorization"

    // token claims
    const val CLAIM_AUTH_KEY = "auth"
    const val CLAIM_USER_ID_KEY = "userId"

    // role
    const val ROLE_PREFIX = "ROLE"
}