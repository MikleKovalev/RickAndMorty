package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.response.ModelsListResponse
import retrofit2.http.GET

interface ApiCharacters {

    @GET(PATH_GET_CHARACTERS)
    suspend fun getCharacters(): ModelsListResponse<Character>

    companion object {
        const val PATH_GET_CHARACTERS = "character/"
    }
}