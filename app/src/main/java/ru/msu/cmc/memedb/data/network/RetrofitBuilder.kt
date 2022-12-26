package ru.msu.cmc.memedb.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {
    private const val BASE_URL = "https://api.imgflip.com"

    val getMemesService: GetMemesService = getRetrofit().create(GetMemesService::class.java)

    val generateMemeService: GenerateMemeService = getRetrofit().create(GenerateMemeService::class.java)

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}