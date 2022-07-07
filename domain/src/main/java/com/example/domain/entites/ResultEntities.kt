package com.example.domain.entites

class ResultEntities(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: DataEntities,
    val location: DataEntities,
    val image: String,
    val episode: ArrayList<String>
)