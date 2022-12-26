package ru.msu.cmc.memedb.presentation.generated

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.msu.cmc.memedb.R
import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.presentation.generation.FragmentMemeGenerator

class FragmentMemeGenerated: Fragment(R.layout.generated_meme) {
    companion object {
        private const val ARG_URL = "ARG_URL"

        fun createFragment(url_str: String): FragmentMemeGenerated {
            val fragment = FragmentMemeGenerated()

            fragment.arguments = Bundle().apply {
                putString(FragmentMemeGenerated.ARG_URL, url_str)
            }

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = view.findViewById<ImageView>(R.id.genImView)
        val backButton = view.findViewById<Button>(R.id.backButtonGenerated)
        val args = requireArguments()

        Glide.with(this).load(args.getString(FragmentMemeGenerated.ARG_URL)).into(image)
        backButton.setOnClickListener{
            activity?.onBackPressed()
        }
    }
}