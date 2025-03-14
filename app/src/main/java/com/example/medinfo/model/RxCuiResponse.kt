package com.example.medinfo.model

data class RxCuiResponse(
    val idGroup: IdGroup
)

data class IdGroup(
    val rxnormId: List<String>
)