package com.michaelm1102.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.EntryPointAccessors

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerLoginComponent.builder().context(this).dependencies(
            EntryPointAccessors.fromApplication(this,LoginEntryPoint::class.java)
        ).build()

        setContentView(R.layout.activity_login)
    }
}