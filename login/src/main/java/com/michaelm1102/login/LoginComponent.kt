package com.michaelm1102.login

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [LoginEntryPoint::class], modules = [LoginModule::class])
interface LoginComponent {

    fun inject(activity: LoginActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun dependencies(loginEntryPoint: LoginEntryPoint): Builder
        fun build(): LoginComponent
    }

}