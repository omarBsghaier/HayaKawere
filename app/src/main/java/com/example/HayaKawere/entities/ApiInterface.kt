package com.example.HayaKawere.entities

import com.google.android.gms.common.api.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*
import kotlin.collections.HashMap

interface ApiInterface {
    @POST("/api/v0/auth/signup")
    fun postUser(@Body user:User): Call<StandardResponse>
    @POST("/api/v0/auth/signin")
    fun postLogin(@Body userLogin: userLogin): Call<StandardResponse>

}

