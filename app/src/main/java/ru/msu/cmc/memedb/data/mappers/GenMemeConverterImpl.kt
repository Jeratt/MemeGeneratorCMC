package ru.msu.cmc.memedb.data.mappers

import ru.msu.cmc.memedb.data.models.network.GenMemeDto

class GenMemeConverterImpl: GenMemeConverter {
    override fun convert(dto: GenMemeDto): String = dto.data.url
}