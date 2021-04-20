package com.example.HayaKawere.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class userLogin {
    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
    constructor( email : String , password :String){
        this.email =email
        this.password= password
    }

}