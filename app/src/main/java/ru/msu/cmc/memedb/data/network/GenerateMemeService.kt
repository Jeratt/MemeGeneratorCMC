package ru.msu.cmc.memedb.data.network

import retrofit2.http.*
import ru.msu.cmc.memedb.data.models.network.GenMemeDto

interface GenerateMemeService {
    @FormUrlEncoded
    //@Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("caption_image")
    suspend fun genMeme(@FieldMap body: HashMap<String?, String?>): GenMemeDto
    //suspend fun genMeme(@Body body: String): GenMemeDto
}