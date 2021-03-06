package com.michaelm1102.nearlabskeleton.data.network.base.model

import com.google.gson.annotations.SerializedName

data class DtoBaseResponse<T>(
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: T
)
