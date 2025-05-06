package com.example.new_test_demo.profille

import java.time.LocalDate

data class User(
    val firstName: String,
    val lastName: String,
    val location: String,
    val gender: String,
    val education: String,
    val experience: String,
    val birthDate: LocalDate? = null
)

