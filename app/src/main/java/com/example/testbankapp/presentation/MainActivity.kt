package com.example.testbankapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testbankapp.R

class MainActivity : AppCompatActivity(), Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.holder)
        if (currentFragment == null) {
            val fragment = MainFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.holder, fragment)
                .commit()
        }
    }

    override fun onClickReg() {
        val fragment = RegFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.holder, fragment)
            .addToBackStack(null)
            .commit()
    }
}