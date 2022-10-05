package com.example.awaistrail.data

import com.google.gson.annotations.SerializedName


data class BannerLarge (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("image" ) var image : String? = null

)