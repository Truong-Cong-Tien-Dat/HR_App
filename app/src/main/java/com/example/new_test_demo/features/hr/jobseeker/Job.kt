package com.example.new_test_demo.features.hr.jobseeker

data class Job(
    val id: Int,
    val title: String,
    val skills: List<String>,
    val experience: String,
    val salary: String,
    val location: String,
    val company: String
)