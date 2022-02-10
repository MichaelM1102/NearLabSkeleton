package com.michaelm1102.common.network.base.model

import com.google.gson.annotations.SerializedName

data class DtoBaseResponse<T>(
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: T
)
