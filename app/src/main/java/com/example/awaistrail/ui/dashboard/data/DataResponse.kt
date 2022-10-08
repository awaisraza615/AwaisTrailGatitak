package com.example.awaistrail.ui.dashboard.data

import com.google.gson.annotations.SerializedName


data class DataResponse (

  @SerializedName("success" ) var success : Boolean?        = null,
  @SerializedName("message" ) var message : String?         = null,
  @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf()

)