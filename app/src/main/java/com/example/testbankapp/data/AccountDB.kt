package com.example.testbankapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo
import com.example.testbankapp.domain.Account
import com.example.testbankapp.domain.SignUpData

@Entity(
    tableName = "accounts",
    indices = [
        Index("login", unique = true)
    ]
)
data class AccountDB(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val login: String,
    val password: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "middle_name") val middleName: String,
    @ColumnInfo(name = "last_name") val lastName: String
) {
    fun toAccount(): Account = Account(
        id = id,
        login = login,
        password = password,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName
    )

    companion object{
        fun fromSignUpData(signUpData: SignUpData): AccountDB = AccountDB(
            id = 0,
            login = signUpData.login,
            password = signUpData.password,
            firstName = signUpData.firstName,
            middleName = signUpData.middleName,
            lastName = signUpData.lastName
        )
    }
}

