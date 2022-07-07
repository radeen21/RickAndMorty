package com.example.domain.interactor

import com.example.domain.FlowableUseCase
import com.example.domain.PostExecutionThread
import com.example.domain.entites.RickyAndMortyEntities
import com.example.domain.repository.RickyAndMortyRepository
import io.reactivex.Flowable

class RickyAndMortyUseCase constructor(
    private val repository: RickyAndMortyRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<RickyAndMortyEntities, RickyAndMortyUseCase.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<RickyAndMortyEntities> =
        repository.getData(params.page)

    data class Params(val page: Int)
}