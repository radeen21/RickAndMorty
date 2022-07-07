package com.example.data.mapper

import com.example.data.dto.RickyAndMortyDto
import com.example.domain.entites.DataEntities
import com.example.domain.entites.InfoEntities
import com.example.domain.entites.ResultEntities
import com.example.domain.entites.RickyAndMortyEntities

class RickyAndMortyMapper : Mapper<RickyAndMortyDto, RickyAndMortyEntities>() {
    override fun apply(from: RickyAndMortyDto): RickyAndMortyEntities {
        return RickyAndMortyEntities(
            InfoEntities(
                from.info.count,
                from.info.next,
                from.info.pages,
                from.info.prev
            ),
            from.results.map { result ->
                ResultEntities(
                    result.id,
                    result.name,
                    result.status,
                    result.species,
                    result.type,
                    result.gender,
                    DataEntities(result.origin.name, result.origin.url),
                    DataEntities(result.location.name, result.location.url),
                    result.image,
                    result.episode
                )
            }
        )
    }
}