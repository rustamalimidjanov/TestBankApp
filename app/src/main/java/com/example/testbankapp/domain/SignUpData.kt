package com.example.testbankapp.domain

data class SignUpData(
    val id: Int,
    val login: String,
    val password: String,
    val repeatPassword: String,
    val firstName: String,
    val middleName: String,
    val lastName: String
)
