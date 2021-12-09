package com.example.retrofit_countrylist_kotlin.retrofit

import com.example.retrofit_countrylist_kotlin.data.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("public/v1/users")
    fun getCountryList(): Call<List<CountryModel>>
}