package com.example.medinfo.model

import com.google.gson.annotations.SerializedName

data class DrugResult(
    @SerializedName("openfda")
    val openFda: OpenFda?,
    val purpose: List<String>?,
    val warnings: List<String>?
)

data class OpenFda(
    @SerializedName("brand_name")
    val brandName: List<String>
)