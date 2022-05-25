package com.example.testbankapp.data

import android.accounts.AuthenticatorException
import android.content.Context
import androidx.room.Room
import com.example.testbankapp.domain.SignUpData

const val DATABASE_NAME = "accounts"

class RoomAccountRepository private constructor(context: Context) {

    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val accountsDao = database.getAccountsDao()


    fun findAccountByLoginAndPassword(login: String, password: String): Int {
        val tuple = accountsDao.findByLogin(login) ?: throw AuthenticatorException()
        if (tuple.password != password) throw AuthenticatorException()
        return tuple.id
    }

    fun createAccount(signUpData: SignUpData) {
        val entity = AccountDB.fromSignUpData(signUpData)
        accountsDao.createAccount(entity)
    }

    fun updateUsername(
        id: Int,
        newFirstName: String,
        newMiddleName: String,
        newLastName: String
    ) {
        accountsDao.updateUsername(
            AccountUpdateUsernameTuple(
                id = id,
                firstName = newFirstName,
                middleName = newMiddleName,
                lastName = newLastName
            )
        )
    }


    companion object {
        private var INSTANCE: RoomAccountRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = RoomAccountRepository(context)
            }
        }

        fun get(): RoomAccountRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }

}