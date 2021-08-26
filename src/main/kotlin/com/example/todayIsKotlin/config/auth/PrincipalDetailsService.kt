package com.example.todayIsKotlin.config.auth

import com.example.todayIsKotlin.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class PrincipalDetailsService : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository //lateinit:접속할때 만들어짐

    override fun loadUserByUsername(username: String?): UserDetails? { // username으로 가져오는 중.
        val user = userRepository!!.findByUsername(username) ?: return null
        return PrincipalDetails(user)
    }
}