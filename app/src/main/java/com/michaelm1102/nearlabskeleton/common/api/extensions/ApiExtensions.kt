package com.michaelm1102.nearlabskeleton.common.api.extensions

import com.google.gson.Gson
import com.michaelm1102.nearlabskeleton.common.api.models.ErrorBody
import com.michaelm1102.nearlabskeleton.common.api.models.State
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

suspend fun <T> safeCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    dataOperation: suspend () -> T
): State<T> {
    return withContext(dispatcher) {
        try {
            State.Success(dataOperation.invoke())
        } catch (throwable: Throwable) {
            if (throwable is UnknownHostException) {
                State.GenericError(Exception("Internet connection problem. please try again"))
            } else {
                State.GenericError(throwable)
            }
        }
    }
}

suspend fun <T> safeCallWithHttpError(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    dataOperation: suspend () -> T
): State<T> {
    return withContext(dispatcher) {
        try {
            State.Success(dataOperation.invoke())
        } catch (httpException: HttpException) {
            val errorBody = getErrorResponse(httpException)
            if (errorBody != null) {
                State.HttpError(errorBody)
            } else {
                State.GenericError(Throwable(httpException))
            }
        } catch (throwable: Throwable) {
            if (throwable is UnknownHostException) {
                State.GenericError(Exception("Internet connection problem. please try again"))
            } else {
                State.GenericError(throwable)
            }
        }
    }
}

private fun getErrorResponse(httpException: HttpException): ErrorBody? =
    getErrorResponse(httpException, ErrorBody::class.java)

private fun <T> getErrorResponse(
    httpException: HttpException,
    errorClass: Class<T>
): T? {
    return try {
        val body = httpException.response()?.errorBody()
        Gson().fromJson(body?.charStream(), errorClass)
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}
