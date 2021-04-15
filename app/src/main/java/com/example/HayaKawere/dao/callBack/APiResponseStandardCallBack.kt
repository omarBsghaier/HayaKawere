package com.example.HayaKawere.dao.callBack

import com.example.HayaKawere.entities.StandardResponse
import com.example.HayaKawere.entities.User
import retrofit2.Response

interface APiResponseStandardCallBack {
    fun success(response: Response<StandardResponse>)
    fun failure(t: Throwable)
}