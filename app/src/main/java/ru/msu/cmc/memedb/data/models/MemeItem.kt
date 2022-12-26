package ru.msu.cmc.memedb.data.models

data class MemeItem(
    val id: Int = 0,
    val name: String? = "",
    val url: String? = "",
    val width: Int = 0,
    val height: Int = 0
)
