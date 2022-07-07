package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class RickyAndMortyDto(
    @SerializedName("info")
    val info: InfoDto,
    @SerializedName("results")
    val results: List<ResultDto>
)