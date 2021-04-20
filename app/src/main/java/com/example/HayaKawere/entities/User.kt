package com.example.HayaKawere.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


  class User {
   @SerializedName("email")
   @Expose
   var email: String? = null

   @SerializedName("password")
   @Expose
   var password: String? = null

   @SerializedName("city")
   @Expose
   var city: String? = null

   @SerializedName("region")
   @Expose
   var region: String? = null

   @SerializedName("lastName")
   @Expose
   var lastName: String? = null

   @SerializedName("firstName")
   @Expose
   var firstName: String? = null
   constructor(email: String, password: String,city:String, region: String,lastName:String,firstName:String) {
    this.firstName=firstName
    this.lastName=lastName
    this.city=city
    this.region=region
    this.email=email
    this.password=password
   }

  }

