package com.example.todayIsKotlin.user.presentation

import com.example.todayIsKotlin.user.infrastucture.User
import com.example.todayIsKotlin.user.application.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.security.Principal
import java.util.logging.Logger

@Controller
class UserController (
    private val userService: UserService,
){
    private val logger = Logger.getLogger(this.javaClass.name)

    @GetMapping("/login")
    fun login(principal: Principal?): String? {
        if(principal != null){
            return "redirect:/user"
        }
        return "user/login"
    }

    @GetMapping("/signUp")
    fun join(): String? {
        return "/user/signUp"
    }

    @PostMapping("/joinProc")
    fun joinProc(userEntity: User, redirectAttributes: RedirectAttributes): String? {
        val result = userService.join(userEntity)
        logger.info("회원가입 결과: ${result}")
        if(!result) {
            redirectAttributes.addAttribute("isExists",true)
            return "redirect:/signUp"
        }
        return "redirect:/login"
    }

    @GetMapping("/user")
    @ResponseBody
    fun user(principal: Principal): String? {
        return "😁현재 사용자 ${principal.name}😁<br/>user 페이지입니다."
    }
}