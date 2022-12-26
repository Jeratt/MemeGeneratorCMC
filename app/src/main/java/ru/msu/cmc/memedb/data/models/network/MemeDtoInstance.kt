package ru.msu.cmc.memedb.data.models.network

data class MemeDtoInstance(
    val id: Int,
    val name: String?,
    val url: String?,
    val width: Int,
    val height: Int,
    val box_count: Int?,
    val captions: Int?
)
