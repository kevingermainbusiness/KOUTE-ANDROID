package ht.koute.android.adapters


import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import ht.koute.android.R
import ht.koute.android.utils.Util
import kotlinx.android.synthetic.main.sermons_row.view.*
import javax.inject.Inject


class SermonsAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseShowsAdapter(R.layout.sermons_row) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val show = shows[position]
        holder.itemView.apply {
            tvAuthor.text = show.author
            tvTitle.text = show.title
            tvDescription.text = show.description
            glide.load(show.coverUrl).into(ivCover)
            tvDate.text = show.postedDate

            holder_3.setOnClickListener {
                Util.createToast(context, show.audioUrl)
            }

//            setOnClickListener {
//                onItemClickListener?.let { clicked ->
//                    clicked(show)
//                }
//            }
        }
    }
}