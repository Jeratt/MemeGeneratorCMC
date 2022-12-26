package ru.msu.cmc.memedb.presentation.list

import ru.msu.cmc.memedb.data.models.MemeItem

interface OnMemeClicked {
    fun onMemeClick(memeItem: MemeItem)
}