package com.example.todayIsKotlin.user.controller

import com.example.todayIsKotlin.user.model.User
import com.example.todayIsKotlin.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.security.Principal


@Controller
class IndexController (
    private val userRepository: UserRepository, //@Autowired말고, 생성자에서 이렇게
    ){
    @Autowired
    private val bCryptPasswordEncoder: BCryptPasswordEncoder? = null

    @GetMapping("", "/")
    @ResponseBody
    fun index(): String? {
        return "인덱스 페이지입니다."
    }

    @GetMapping("/login")
    fun login(principal: Principal?): String? {
        if(principal != null){
            return "redirect:/user"
        }
        return "login"
    }

    @GetMapping("/join")
    fun join(): String? {
        return "join"
    }

    @PostMapping("/joinProc")
    fun joinProc(user: User): String? {
        val rawPassword: String? = user.password
        val encPassword = bCryptPasswordEncoder!!.encode(rawPassword)
        user.password = encPassword
        userRepository?.save(user)
        return "redirect:/login"
    }

    @GetMapping("/admin")
    @ResponseBody
    fun admin(): String? {
        return "admin 페이지입니다."
    }

    @GetMapping("/user")
    @ResponseBody
    fun user(principal: Principal): String? {
        return "😁현재 사용자 ${principal.name}😁<br/>user 페이지입니다."
    }

    @GetMapping("/home")
    @ResponseBody
    fun home(principal: Principal): String? {
        return "😁현재 사용자 ${principal.name}😁<br/>home 페이지입니다."
    }
}