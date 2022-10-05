package com.example.awaistrail.data

import com.google.gson.annotations.SerializedName


data class BannerSmall (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("image" ) var image : String? = null

)