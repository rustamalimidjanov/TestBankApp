package com.example.testbankapp.data

import androidx.room.ColumnInfo

data class AccountSignInTuple(
    val id: Int,
    val password: String
)

data class AccountUpdateUsernameTuple(
    val id: Int,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "middle_name") val middleName: String,
    @ColumnInfo(name = "last_name") val lastName: String
)