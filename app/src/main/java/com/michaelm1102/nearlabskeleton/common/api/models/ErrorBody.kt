package com.michaelm1102.nearlabskeleton.common.api.models

import com.google.gson.annotations.SerializedName

data class ErrorBody(
    @SerializedName("statusCode")
    var status: Int?,

    @SerializedName("error")
    val error: String?,

    @SerializedName("message")
    val message: String?
)