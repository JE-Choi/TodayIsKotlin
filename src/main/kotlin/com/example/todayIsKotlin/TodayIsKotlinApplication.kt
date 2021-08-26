package com.example.todayIsKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodayIsKotlinApplication

fun main(args: Array<String>) {
	runApplication<TodayIsKotlinApplication>(*args)
}