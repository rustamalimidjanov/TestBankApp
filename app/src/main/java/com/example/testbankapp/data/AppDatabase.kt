package com.example.testbankapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [AccountDB::class]
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getAccountsDao(): AccountsDao
}