package ru.msu.cmc.memedb.data.repositories

import ru.msu.cmc.memedb.data.models.MemeItem

interface MemeRepository {
    suspend fun getMemes(): List<MemeItem>
}