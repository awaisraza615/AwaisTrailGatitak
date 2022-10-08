package com.example.awaistrail.ui.dashboard.data

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("id"               ) var id              : Int?             = null,
  @SerializedName("title"            ) var title           : String?          = null,
  @SerializedName("is_see_all_shown" ) var isSeeAllShown   : Boolean?         = null,
  @SerializedName("type"             ) var type            : String?          = null,
  @SerializedName("background_color" ) var backgroundColor : String?          = null,
  @SerializedName("items"            ) var items: Any? =""

)
