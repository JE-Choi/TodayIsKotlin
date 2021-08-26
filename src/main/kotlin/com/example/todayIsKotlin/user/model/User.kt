package com.example.todayIsKotlin.user.model

import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
class User (var username: String?, var password: String?, var email: String?, var role: String?){
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0
    @CreationTimestamp
    private val createDate: Timestamp? = null

}