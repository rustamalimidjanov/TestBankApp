package com.example.testbankapp.data

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface AccountsDao {

    @Query("SELECT id, password FROM accounts WHERE login = :login")
    fun findByLogin(login: String): AccountSignInTuple?

    @Update(entity = AccountDB::class)
    fun updateUsername(updateUsername: AccountUpdateUsernameTuple)

    @Insert
    fun createAccount(accountDB: AccountDB)
}