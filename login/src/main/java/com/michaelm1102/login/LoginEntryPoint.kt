package com.michaelm1102.login

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LoginEntryPoint {

    fun getRetrofit():Retrofit
}