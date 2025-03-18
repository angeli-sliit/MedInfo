package com.example.medinfo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val FDA_BASE_URL = "https://api.fda.gov/"
    private const val RX_BASE_URL = "https://rxnav.nlm.nih.gov/"

    private val fdaRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(FDA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val rxRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(RX_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val fdaApi: MedicineService by lazy {
        fdaRetrofit.create(MedicineService::class.java)
    }

    val rxApi: MedicineService by lazy {
        rxRetrofit.create(MedicineService::class.java)
    }
}