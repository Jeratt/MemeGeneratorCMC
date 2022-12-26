package ru.msu.cmc.memedb.data.datastores

import ru.msu.cmc.memedb.data.models.network.GenMemeDto
import ru.msu.cmc.memedb.data.models.network.MemeDto
import ru.msu.cmc.memedb.data.network.GenerateMemeService
import ru.msu.cmc.memedb.data.network.GetMemesService

class NetworkGenMemeDataStore(
    private val generateMemeService: GenerateMemeService)
{
    suspend fun genMeme(body: HashMap<String?, String?>): GenMemeDto = generateMemeService.genMeme(body)
}