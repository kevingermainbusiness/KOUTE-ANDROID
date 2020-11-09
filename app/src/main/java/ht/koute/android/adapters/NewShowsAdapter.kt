package ht.koute.android.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import ht.koute.android.R
import kotlinx.android.synthetic.main.new_shows_row.view.*
import javax.inject.Inject

class NewShowsAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseShowsAdapter(R.layout.new_shows_row) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val show = shows[position]
        holder.itemView.apply {
            title.text = show.title
            author.text = show.author
            glide.load(show.coverUrl).into(coverUrl)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(show)
                }
            }
        }
    }
}