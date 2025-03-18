package com.example.medinfo.network

import com.example.medinfo.model.MedicineDetails
import com.example.medinfo.model.InteractionResponse
import com.example.medinfo.model.FdaResponse
import com.example.medinfo.model.RxCuiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MedicineService {
    @GET("drug/label.json")
    suspend fun getDrugWarnings(
        @Query("search") drugName: String
    ): Response<FdaResponse>

    @GET("REST/rxcui.json")
    suspend fun getRxCui(
        @Query("name") drugName: String
    ): Response<RxCuiResponse>

    @GET("REST/interaction/interaction.json")
    suspend fun getDrugInteractions(
        @Query("rxcui") rxcui: String
    ): Response<InteractionResponse>

    @GET("details")
    suspend fun getMedicineDetails(
        @Query("id") id: String
    ): Response<MedicineDetails>
}