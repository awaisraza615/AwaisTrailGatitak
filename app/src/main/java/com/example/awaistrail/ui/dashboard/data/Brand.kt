package com.example.awaistrail.ui.dashboard.data

import com.google.gson.annotations.SerializedName

data class Brand(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("logo") var logo: String? = null
)