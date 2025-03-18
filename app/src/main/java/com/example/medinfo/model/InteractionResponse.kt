package com.example.medinfo.model

data class InteractionResponse(
    val interactionTypeGroup: List<InteractionTypeGroup>
)

data class InteractionTypeGroup(
    val interactionType: List<InteractionType>
)

data class InteractionType(
    val description: String?
)