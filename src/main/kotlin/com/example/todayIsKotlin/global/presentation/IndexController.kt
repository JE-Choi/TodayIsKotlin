package com.example.todayIsKotlin.global.presentation

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.util.logging.Logger

@Controller
class IndexController {
    private val LOGGER = Logger.getLogger(this.javaClass.name)

    @GetMapping("", "/")
    fun index(): String? {
        return "index"
    }
}