package ht.koute.android.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import ht.koute.android.R
import kotlinx.android.synthetic.main.category_row.view.*
import javax.inject.Inject

class CategoriesAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseShowsAdapter(R.layout.category_row) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val categoryShow = shows[position]
        holder.itemView.apply {
            title.text = categoryShow.title
            author.text = categoryShow.author
            glide.load(categoryShow.coverUrl).into(coverUrl)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(categoryShow)
                }
            }
        }
    }
}