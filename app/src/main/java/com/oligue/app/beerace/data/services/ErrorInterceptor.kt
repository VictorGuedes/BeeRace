package com.oligue.app.beerace.data.services

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.oligue.app.beerace.data.model.RestError
import com.oligue.app.beerace.data.services.exceptions.ErrorException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class ErrorInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (response.isSuccessful) {
            return response
        }

        if (response.code == 403){
            val error = response.body.use { body ->
                getErrorMessage(body)
            }

            throw ErrorException(error)
        }

        throw IOException()
    }


    private fun getErrorMessage(errorBody: ResponseBody?): String? {
        val error = checkError(errorBody)
        if (error == null) {
            return null
        }

        return error.captchaUrl
    }

    private fun checkError(errorBody: ResponseBody?): RestError? {
        val gson = Gson()

        return try {
            gson.fromJson(errorBody?.charStream(), RestError::class.java)
        } catch (e: JsonSyntaxException) {
            null
        } catch (e: IOException) {
            null
        }
    }
}