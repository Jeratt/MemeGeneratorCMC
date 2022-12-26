package ru.msu.cmc.memedb.data.mappers

import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.data.models.network.MemeDto

class MemeItemConverterImpl: MemeItemConverter {
    override fun convert(dto: MemeDto): List<MemeItem> = dto.data.memes.map{MemeItem(it.id,it.name,it.url,it.width,it.height)}
        //MemeItem(dto.data.id, dto.data.name, dto.data.url, dto.data.width, dto.data.height)

    //override fun convertList(lst: List<MemeDto>): List<MemeItem> = lst.map { convert(it) }
}