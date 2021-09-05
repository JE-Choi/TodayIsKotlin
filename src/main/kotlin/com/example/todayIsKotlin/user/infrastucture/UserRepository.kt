package com.example.todayIsKotlin.user.infrastucture

import org.springframework.data.jpa.repository.JpaRepository

// JpaRepository 를 상속하면 자동 컴포넌트 스캔됨.
interface UserRepository : JpaRepository<User?, Int?> {
    // Jpa Naming 전략
    // SELECT * FROM user WHERE username = 1?
    fun findByUsername(username: String?): User?
    // @Query(value = "select * from user", nativeQuery = true)
}
