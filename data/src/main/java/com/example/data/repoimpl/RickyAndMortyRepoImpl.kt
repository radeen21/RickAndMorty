package com.example.data.repoimpl

import com.example.data.api.ApiService
import com.example.data.mapper.RickyAndMortyMapper
import com.example.domain.entites.RickyAndMortyEntities
import com.example.domain.repository.RickyAndMortyRepository
import io.reactivex.Flowable
import javax.inject.Inject

class RickyAndMortyRepoImpl @Inject constructor(
    private val api: ApiService,
    private val rickyAndMortyMapper: RickyAndMortyMapper,
) : RickyAndMortyRepository {

    override fun getData(page: Int): Flowable<RickyAndMortyEntities>  =
        api.getData(page).map(rickyAndMortyMapper)
}