package com.example.todayIsKotlin.admin.presentation

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.logging.Logger

@Controller
class AdminController (){
    private val logger = Logger.getLogger(this.javaClass.name)
    @GetMapping("/admin")
    @ResponseBody
    fun admin(): String? {
        return "admin 페이지입니다."
    }
}