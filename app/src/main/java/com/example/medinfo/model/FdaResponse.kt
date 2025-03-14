package com.example.medinfo.model

data class FdaResponse(
    val results: List<Result>
)

data class Result(
    val warnings: List<String>
)