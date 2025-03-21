package com.example.medinfo.model

import com.google.gson.annotations.SerializedName

data class FdaResponse(
    val results: List<FdaResult>
)

data class FdaResult(
    @SerializedName("openfda")
    val openFda: OpenFda?,
    val purpose: List<String>?,
    val warnings: List<String>?
)