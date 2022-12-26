package ru.msu.cmc.memedb.data.models.network

data class MemeDto(
    /*
    val id: Int,
    val name: String?,
    val url: String?,
    val width: Int,
    val height: Int,
    val box_count: Int?,
    val captions: Int?
     */
    val success: String,
    val data: MemeDtoMemes
)