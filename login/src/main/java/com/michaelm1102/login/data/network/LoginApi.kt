package com.michaelm1102.login.data.network

import com.michaelm1102.common.network.base.model.DtoBaseResponse
import retrofit2.http.POST

interface LoginApi {
    @POST("login")
    //Todo replace with real response class
    suspend fun handleLogin(): DtoBaseResponse<Any>

}