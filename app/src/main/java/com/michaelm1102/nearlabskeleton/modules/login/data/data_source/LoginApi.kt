package com.michaelm1102.nearlabskeleton.modules.login.data.data_source

import com.michaelm1102.nearlabskeleton.common.api.models.DtoBaseResponse
import retrofit2.http.POST

interface LoginApi {
    @POST("login")
    //Todo replace with real response class
    suspend fun handleLogin(): DtoBaseResponse<Any>

}