package com.michaelm1102.nearlabskeleton.data.network.login

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object LoginApiModule {
    @Provides
    @ViewModelScoped
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }
}