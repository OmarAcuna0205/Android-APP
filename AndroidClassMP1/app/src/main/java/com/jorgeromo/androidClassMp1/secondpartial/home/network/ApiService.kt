// com/jorgromo/androidClassMp1/secondpartial/home/network/ApiService.kt

package com.jorgeromo.androidClassMp1.secondpartial.home.network

import com.jorgeromo.androidClassMp1.secondpartial.home.model.HomeScreenResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("OmarAcuna0205/3bb76db1f01edb9616215569ca5d946c/raw/c3696e0e7371b0784afec14b8aa326ca2f02be87/data.json")
    suspend fun getHomeScreenData(): HomeScreenResponse
}

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}