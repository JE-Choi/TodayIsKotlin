package com.example.todayIsKotlin.user.application

import com.example.todayIsKotlin.user.infrastucture.User
import com.example.todayIsKotlin.user.infrastucture.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
) : UserService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)
    override fun join(userEntity: User): Boolean {
        if (userEntity?.username != null && checkExist(userEntity.username!!)) {
            logger.debug("이미 존재하는 username")
            return false
        }
        val rawPassword: String? = userEntity.password
        val encPassword = bCryptPasswordEncoder!!.encode(rawPassword)
        userEntity.password = encPassword
        userRepository?.save(userEntity)
        return true
    }

    override fun checkExist(pk: String): Boolean {
        val userEntity: User? = userRepository.findByUsername(pk)
        return Objects.nonNull(userEntity)
    }

    override fun findUserByUsername(username: String): User?{
        return userRepository.findByUsername(username)
    }
}