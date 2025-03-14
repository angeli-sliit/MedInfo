package com.example.medinfo.model

data class MedicineDetails(
    val name: String,
    val uses: String,
    val ingredients: List<String>,
    val sideEffects: List<String>
)