package ru.msu.cmc.memedb.data.datastores

import ru.msu.cmc.memedb.data.models.MemeItem

class MockMemeStore {
    fun getMemes(): List<MemeItem> = listOf(
        MemeItem(
            id=181913649,
            name="Drake Hotline Bling",
            url="https://i.imgflip.com/30b1gx.jpg",
            width = 1200,
            height = 1200
        ),

        MemeItem(
            id=87743020,
            name="Two Buttons",
            url="https://i.imgflip.com/1g8my4.jpg",
            width=600,
            height=908
        )
    )
}