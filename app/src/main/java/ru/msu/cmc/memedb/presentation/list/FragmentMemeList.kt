package ru.msu.cmc.memedb.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.msu.cmc.memedb.R
import ru.msu.cmc.memedb.data.datastores.MockMemeStore
import ru.msu.cmc.memedb.data.datastores.NetworkMemeDataStore
import ru.msu.cmc.memedb.data.mappers.MemeItemConverterImpl
import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.data.network.RetrofitBuilder
import ru.msu.cmc.memedb.data.repositories.MemeRepository
import ru.msu.cmc.memedb.data.repositories.MemeRepositoryImpl
import ru.msu.cmc.memedb.presentation.generation.FragmentMemeGenerator
import ru.msu.cmc.memedb.presentation.list.adapters.MemeAdapter

class FragmentMemeList: Fragment(R.layout.fmt_memelist), OnMemeClicked {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val repository: MemeRepository = MemeRepositoryImpl(
            NetworkMemeDataStore(RetrofitBuilder.getMemesService),
            MemeItemConverterImpl(),
            Dispatchers.IO
        )

        val memeAdapter = MemeAdapter(this)
        recycler.adapter = memeAdapter

        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.getMemes()
            memeAdapter.addItems(result)
        }

//        recycler.adapter = MemeAdapter(repository.getMemes(), this)
    }

    override fun onMemeClick(memeItem: MemeItem) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fmt_container, FragmentMemeGenerator.createFragment(memeItem))
            .addToBackStack(null)
            .commit()
    }
}