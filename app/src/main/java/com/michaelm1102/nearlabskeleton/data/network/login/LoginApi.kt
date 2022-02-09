package com.michaelm1102.nearlabskeleton.data.network.login

import com.michaelm1102.nearlabskeleton.data.network.base.model.DtoBaseResponse
import retrofit2.Response
import retrofit2.http.POST

interface LoginApi {
    @POST("login")
    //Todo replace with real response class
    suspend fun handleLogin(): DtoBaseResponse<Any>

}