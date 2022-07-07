package com.example.domain.entites

import com.google.gson.annotations.SerializedName

class InfoEntities(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String?
)