package ru.msu.cmc.memedb.data.repositories

import ru.msu.cmc.memedb.data.models.network.GenMemeDto

interface GenMemeRepository {
    suspend fun genMeme(body: HashMap<String?, String?>): String
}