package ru.msu.cmc.memedb.data.mappers

import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.data.models.network.MemeDto

interface MemeItemConverter {
    fun convert(dto: MemeDto): List<MemeItem>

    //fun convertList(lst: List<MemeDto>): List<MemeItem>
}