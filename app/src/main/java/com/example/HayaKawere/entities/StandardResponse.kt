package com.example.HayaKawere.entities

import com.google.gson.annotations.SerializedName

data class StandardResponse(
    @SerializedName("msg")
    var message: String,
    @SerializedName("code")
    var status: Int
) {
}