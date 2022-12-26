package ru.msu.cmc.memedb.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.msu.cmc.memedb.data.datastores.MockMemeStore
import ru.msu.cmc.memedb.data.datastores.NetworkMemeDataStore
import ru.msu.cmc.memedb.data.mappers.MemeItemConverter
import ru.msu.cmc.memedb.data.mappers.MemeItemConverterImpl
import ru.msu.cmc.memedb.data.models.MemeItem

class MemeRepositoryImpl(
    private val networkMemeDS: NetworkMemeDataStore,
    private val memeConverter: MemeItemConverter,
    private val dispatcher: CoroutineDispatcher
): MemeRepository {
    override suspend fun getMemes(): List<MemeItem> = withContext(dispatcher) {
        networkMemeDS.getMemes().let {
            memeConverter.convert(it)
        }
    }
}