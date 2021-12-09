package com.example.retrofit_countrylist_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_countrylist_kotlin.adapter.CountryListAdapter
import com.example.retrofit_countrylist_kotlin.databinding.ActivityMainBinding
import com.example.retrofit_countrylist_kotlin.viewModel.MainActivityViewModel
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var recyclerAdapter:CountryListAdapter
    lateinit var viewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView(){
        binding.countryListRecyclerviewId.layoutManager=LinearLayoutManager(this)
        recyclerAdapter=CountryListAdapter(this)
     //   binding.countryListRecyclerviewId.adapter=CountryListAdapter(this)
        binding.countryListRecyclerviewId.adapter=recyclerAdapter
    }
    private fun initViewModel(){
        val viewModel:MainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
       // viewModel.makeApiCall()
        viewModel.getLiveDataObserver().observe(this, Observer{
            if(it!=null){
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }

}