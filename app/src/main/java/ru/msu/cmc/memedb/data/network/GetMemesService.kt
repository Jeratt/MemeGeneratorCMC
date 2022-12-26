package ru.msu.cmc.memedb.data.network

import retrofit2.Call
import retrofit2.http.GET
import ru.msu.cmc.memedb.data.models.network.MemeDto

interface GetMemesService {
    @GET("get_memes")
    suspend fun getMemes(): MemeDto
}