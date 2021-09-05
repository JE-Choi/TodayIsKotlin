package com.example.todayIsKotlin.config.auth

import com.example.todayIsKotlin.user.application.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class PrincipalDetailsService(private val userService: UserService) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails? {
        if(username == null){
            return null
        }
        val user = userService.findUserByUsername(username) ?: return null
        return PrincipalDetails(user)
    }
}