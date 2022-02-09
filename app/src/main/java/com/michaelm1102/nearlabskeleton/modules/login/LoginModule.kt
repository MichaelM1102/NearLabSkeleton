package com.michaelm1102.nearlabskeleton.modules.login

import com.michaelm1102.nearlabskeleton.common.room.NearDatabase
import com.michaelm1102.nearlabskeleton.modules.login.data.data_source.LoginApi
import com.michaelm1102.nearlabskeleton.modules.login.data.data_source.LoginDao
import com.michaelm1102.nearlabskeleton.modules.login.data.repository.LoginRepository
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

    @Provides
    @ViewModelScoped
    fun provideLoginDao(database: NearDatabase): LoginDao {
        return database.loginDao
    }

    // if dao exist provide login dao
    // and embed in repository
    @Provides
    @ViewModelScoped
    fun provideLoginRepository(loginApi: LoginApi, loginDao: LoginDao): LoginRepository {
        return LoginRepository(loginApi, loginDao)
    }


}