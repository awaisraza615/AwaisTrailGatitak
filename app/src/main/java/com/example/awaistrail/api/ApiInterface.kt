package com.example.awaistrail.api

import com.example.awaistrail.data.DataResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("/v3/b0d53563-ab1d-42c0-ada2-73b14e166f4e")
    suspend fun getData(): Response<DataResponse>

    @GET("/v3/11af52c3-4c2d-40cd-83bd-0c7d9a8690f5")
    suspend fun getData2(): Response<DataResponse>

    @GET("/v3/23cba776-babc-4587-a7b3-13b29b7f44d9")
    suspend fun getData3(): Response<DataResponse>
}