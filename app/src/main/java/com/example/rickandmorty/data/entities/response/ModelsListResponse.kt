package com.example.rickandmorty.data.entities.response

data class ModelsListResponse<T>(
    val info: ResponseInfo? = null,
    val results: List<T>? = null
)