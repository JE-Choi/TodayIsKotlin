package com.example.todayIsKotlin.user.application

import com.example.todayIsKotlin.user.infrastucture.User

interface UserService {
    fun join(userEntity: User): Boolean
    fun checkExist(pk:String): Boolean
    fun findUserByUsername(username: String): User?
}