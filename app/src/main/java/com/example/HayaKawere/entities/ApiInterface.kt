package com.example.HayaKawere.entities

import retrofit2.Call
import retrofit2.http.*
import java.util.*
import kotlin.collections.HashMap

interface ApiInterface {
    @POST("/api/v0/auth/signup")
    fun postUser(@Body user:User): Call<StandardResponse>
    @FormUrlEncoded
    @POST("/api/v0/auth/signin")
    fun postLogin(@Field("email") email :String, @Field("password") password:String) : Call<StandardResponse>


}

