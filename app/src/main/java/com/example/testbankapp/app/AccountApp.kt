package com.example.testbankapp.app

import android.app.Application
import com.example.testbankapp.data.RoomAccountRepository

class AccountApp: Application() {
    override fun onCreate() {
        super.onCreate()
        RoomAccountRepository.initialize(this)
    }
}