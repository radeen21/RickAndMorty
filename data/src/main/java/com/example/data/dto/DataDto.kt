package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)