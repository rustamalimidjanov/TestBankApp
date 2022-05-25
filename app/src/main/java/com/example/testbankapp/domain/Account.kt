package com.example.testbankapp.domain

data class Account(
    val id: Int,
    val login: String,
    val password: String,
    val firstName: String,
    val middleName: String,
    val lastName: String
)
