package com.example.medinfo.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.medinfo.model.RxCuiResponse
import com.example.medinfo.model.InteractionResponse
import com.example.medinfo.model.FdaResponse
import com.example.medinfo.model.Medicine
import com.example.medinfo.model.MedicineDetails

interface MedicineService {
    // RxNorm API
    @GET("rxcui.json")
    fun getRxCui(@Query("name") drugName: String): Call<RxCuiResponse>

    @GET("interaction/interaction.json")
    fun getDrugInteractions(@Query("rxcui") rxcui: String): Call<InteractionResponse>

    // OpenFDA API
    @GET("drug/label.json")
    fun getDrugWarnings(@Query("search") drugName: String): Call<FdaResponse>

    // Additional methods for searching and getting details
    @GET("search")
    suspend fun searchMedicine(@Query("name") name: String): List<Medicine>

    @GET("details")
    suspend fun getMedicineDetails(@Query("id") id: String): MedicineDetails
}