package com.example.domain.repository

import com.example.domain.entites.RickyAndMortyEntities
import io.reactivex.Flowable

interface RickyAndMortyRepository {
    fun getData(page: Int): Flowable<RickyAndMortyEntities>
}