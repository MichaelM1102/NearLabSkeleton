package com.michaelm1102.nearlabskeleton.common.api.models

import com.google.gson.annotations.SerializedName
import com.michaelm1102.nearlabskeleton.common.api.Dto

data class DtoBaseResponse<T>(
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: T
): Dto
