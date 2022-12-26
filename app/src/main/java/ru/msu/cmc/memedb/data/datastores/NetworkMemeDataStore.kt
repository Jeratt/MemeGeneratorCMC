package ru.msu.cmc.memedb.data.datastores

import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.data.models.network.MemeDto
import ru.msu.cmc.memedb.data.network.GetMemesService

class NetworkMemeDataStore (
    private val getMemesService: GetMemesService
    ){
       suspend fun getMemes(): MemeDto = getMemesService.getMemes()
}