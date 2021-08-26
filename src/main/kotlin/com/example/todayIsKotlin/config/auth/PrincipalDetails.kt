package com.example.todayIsKotlin.config.auth

import com.example.todayIsKotlin.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class PrincipalDetails(private var user: User) : UserDetails {

    override fun getPassword(): String? {
        return user.password
    }

    override fun getUsername(): String? {
        return user.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val collet: MutableCollection<GrantedAuthority> = ArrayList()
        collet.add(GrantedAuthority { user.role})
        return collet
    }

}
