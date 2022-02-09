package com.michaelm1102.nearlabskeleton.ui.login

import com.michaelm1102.nearlabskeleton.data.network.login.LoginApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object LoginModule {
    @Provides
    @ViewModelScoped
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    // if dao exist provide login dao
    // and embed in repository
    @Provides
    @ViewModelScoped
    fun provideLoginRepository(loginApi: LoginApi): LoginRepository {
        return LoginRepository(loginApi)
    }


}