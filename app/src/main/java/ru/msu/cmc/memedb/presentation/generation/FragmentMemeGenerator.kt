package ru.msu.cmc.memedb.presentation.generation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.msu.cmc.memedb.R
import ru.msu.cmc.memedb.data.datastores.NetworkGenMemeDataStore
import ru.msu.cmc.memedb.data.datastores.NetworkMemeDataStore
import ru.msu.cmc.memedb.data.mappers.GenMemeConverterImpl
import ru.msu.cmc.memedb.data.mappers.MemeItemConverterImpl
import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.data.network.RetrofitBuilder
import ru.msu.cmc.memedb.data.repositories.GenMemeRepository
import ru.msu.cmc.memedb.data.repositories.GenMemeRepositoryImpl
import ru.msu.cmc.memedb.data.repositories.MemeRepository
import ru.msu.cmc.memedb.data.repositories.MemeRepositoryImpl
import ru.msu.cmc.memedb.presentation.generated.FragmentMemeGenerated

class FragmentMemeGenerator: Fragment(R.layout.fmt_meme_generator), OnMemeGenerated {
    companion object{
        private const val ARG_ID = "ARG_ID"
        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_URL = "ARG_URL"
        private const val ARG_WIDTH = "ARG_WIDTH"
        private const val ARG_HEIGHT = "ARG_HEIGHT"

        fun createFragment(memeItem: MemeItem): FragmentMemeGenerator{
            val fragment = FragmentMemeGenerator()

            fragment.arguments = Bundle().apply {
                putInt(ARG_ID, memeItem.id)
                putString(ARG_NAME, memeItem.name)
                putString(ARG_URL, memeItem.url)
                putInt(ARG_WIDTH, memeItem.width)
                putInt(ARG_HEIGHT, memeItem.height)
            }

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.imageView)
        val backButton = view.findViewById<Button>(R.id.backButton)
        val genButton = view.findViewById<Button>(R.id.genButton)
        val editText1 = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.firstTextEdit)
        val editText2 = view.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.secTextEdit)
        val args = requireArguments()
        val repository: GenMemeRepository = GenMemeRepositoryImpl(
            NetworkGenMemeDataStore(RetrofitBuilder.generateMemeService),
            GenMemeConverterImpl(),
            Dispatchers.IO
        )

        Glide.with(this).load(args.getString(ARG_URL)).into(image)
        backButton.setOnClickListener{
            activity?.onBackPressed()
        }
        genButton.setOnClickListener{
            val meme_id = args.getInt(ARG_ID)
            val text1: String = editText1.text.toString()
            val text2: String = editText2.text.toString()
            /*
            val body: String = "template_id=${meme_id}&username=TestCMCAndroid&" +
                    "password=iKyzgbEW16aqODTOQPuf&text0=${text1}&text1=${text2}"

             */
            val body = HashMap<String?, String?>()
            body["template_id"] = meme_id.toString()
            body["username"] = "TestCMCAndroid"
            body["password"] = "iKyzgbEW16aqODTOQPuf"
            body["text0"] = text1
            body["text1"] = text2
            CoroutineScope(Dispatchers.Main).launch {
                val result = repository.genMeme(body)
                onMemeGen(result)
            }
        }
    }

    override fun onMemeGen(url_meme: String) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fmt_container, FragmentMemeGenerated.createFragment(url_meme))
            .addToBackStack(null)
            .commit()
    }
}

//val id: Int = 0,
//val name: String = "",
//val url: String = "",
//val width: Int = 0,
//val height: Int = 0