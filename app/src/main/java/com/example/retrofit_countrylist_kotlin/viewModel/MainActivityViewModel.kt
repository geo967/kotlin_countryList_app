package com.example.retrofit_countrylist_kotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit_countrylist_kotlin.data.CountryModel
import com.example.retrofit_countrylist_kotlin.retrofit.RetroInstance
import com.example.retrofit_countrylist_kotlin.retrofit.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivityViewModel: ViewModel() {
    var  liveDataList:MutableLiveData<List<CountryModel>> = MutableLiveData()

    fun getLiveDataObserver():MutableLiveData<List<CountryModel>>{
        return liveDataList
    }

    fun makeApiCall(){
        val retroInstance=RetroInstance.getRetrofitInstance()
        val retroService=retroInstance.create(RetroService::class.java)
        val call=retroService.getCountryList()
        call.enqueue(object:Callback<List<CountryModel>>{
            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }

}