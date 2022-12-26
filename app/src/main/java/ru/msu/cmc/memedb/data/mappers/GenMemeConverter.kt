package ru.msu.cmc.memedb.data.mappers

import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.data.models.network.GenMemeDto
import ru.msu.cmc.memedb.data.models.network.MemeDto

interface GenMemeConverter {
    fun convert(dto: GenMemeDto): String
}