package ht.koute.android.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import ht.koute.android.R
import kotlinx.android.synthetic.main.new_shows_row.view.*
import javax.inject.Inject

class RecomShowsAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseShowsAdapter(R.layout.new_shows_row) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val recommendedShow = shows[position]
        holder.itemView.apply {
            title.text = recommendedShow.title
            author.text = recommendedShow.author
            glide.load(recommendedShow.coverUrl).into(coverUrl)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(recommendedShow)
                }
            }
        }
    }
}