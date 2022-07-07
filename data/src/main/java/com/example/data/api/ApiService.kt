package com.example.data.api

import com.example.data.dto.RickyAndMortyDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    fun getData(
        @Query("page") type: Int,
    ): Flowable<RickyAndMortyDto>

}