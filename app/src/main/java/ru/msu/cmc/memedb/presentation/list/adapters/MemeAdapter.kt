package ru.msu.cmc.memedb.presentation.list.adapters

import android.content.DialogInterface
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.msu.cmc.memedb.R
import ru.msu.cmc.memedb.data.models.MemeItem
import ru.msu.cmc.memedb.presentation.list.OnMemeClicked

class MemeAdapter(
    private val onClickAction: OnMemeClicked
    ): RecyclerView.Adapter<MemeAdapter.ViewHolder>() {

    private val dataSet: MutableList<MemeItem> = mutableListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val memeCard: View
        val imgPreview: ImageView
        val memeName: TextView

        init{
            memeCard = view.findViewById(R.id.memeCard)
            imgPreview = view.findViewById(R.id.imgPreview)
            memeName = view.findViewById(R.id.memeTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meme_item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            Glide.with(imgPreview.context).load(dataSet[position].url).into(imgPreview);
            memeName.text = dataSet[position].name
            memeCard.setOnClickListener(){
            onClickAction.onMemeClick(dataSet[position])
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size

    fun addItems(items: List<MemeItem>) {
        val start = dataSet.size
        dataSet.addAll(items)
        notifyItemInserted(start)
    }
}