package com.example.eduardmishchenkoapp.projects.rickandmorty.api

import com.example.eduardmishchenkoapp.projects.rickandmorty.models.ResponseApi
import com.example.eduardmishchenkoapp.projects.rickandmorty.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<ResponseApi>
}