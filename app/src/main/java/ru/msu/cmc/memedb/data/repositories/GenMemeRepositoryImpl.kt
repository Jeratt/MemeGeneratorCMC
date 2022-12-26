package ru.msu.cmc.memedb.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.msu.cmc.memedb.data.datastores.NetworkGenMemeDataStore
import ru.msu.cmc.memedb.data.mappers.GenMemeConverter
import ru.msu.cmc.memedb.data.models.network.GenMemeDto

class GenMemeRepositoryImpl(
    private val networkGenMemeDS: NetworkGenMemeDataStore,
    private val memeConverter: GenMemeConverter,
    private val dispatcher: CoroutineDispatcher): GenMemeRepository {
    override suspend fun genMeme(body: HashMap<String?, String?>): String = withContext(dispatcher) {
        networkGenMemeDS.genMeme(body).let{
            memeConverter.convert(it)
        }
    }
}