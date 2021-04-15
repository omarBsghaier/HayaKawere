package com.example.HayaKawere.dao

import com.example.HayaKawere.dao.callBack.APiResponseStandardCallBack
import com.example.HayaKawere.entities.ApiInterface
import com.example.HayaKawere.entities.StandardResponse
import com.example.HayaKawere.entities.User
import com.example.HayaKawere.util.Constantes

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GestionUserDao {
    var retrofit: Retrofit? = null
    var userinterface: ApiInterface?=null
    companion object {
        private var self: GestionUserDao? = null

        fun instance(): GestionUserDao {
            if (self == null) {
                synchronized(GestionUserDao::class.java) {
                    if (self == null) {
                        self = GestionUserDao()
                    }
                }
            }
            return self!!
        }

    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constantes.instance().URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
         userinterface = retrofit!!.create(ApiInterface::class.java)

    }

     fun signUpWithEmailAndPassword(user: User, aPiResponseCallBack: APiResponseStandardCallBack) {

        var call: Call<StandardResponse> = userinterface!!.postUser(user)
        call.enqueue(object : Callback<StandardResponse> {

            override fun onResponse(call: Call<StandardResponse>, response: Response<StandardResponse>) {
                aPiResponseCallBack.success(response)
            }

            override fun onFailure(call: Call<StandardResponse>, t: Throwable) {
                aPiResponseCallBack.failure(t)


            }

        })

    }
    fun loginWithEmailAndPassword (email : String,password :String, aPiResponseCallBack: APiResponseStandardCallBack)
    {
        val call: Call<StandardResponse> =userinterface!!.postLogin(email,password)
        call.enqueue(object : Callback<StandardResponse> {

            override fun onResponse(call: Call<StandardResponse>, response: Response<StandardResponse>) {
                aPiResponseCallBack.success(response)

            }


            override fun onFailure(call: Call<StandardResponse>, t: Throwable) {
                aPiResponseCallBack.failure(t)
            }

        })


    }


    }

