package ht.koute.android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import ht.koute.android.R
import ht.koute.android.utils.SuggestionsClickListener
import ht.koute.android.data.Suggestions
import kotlinx.android.synthetic.main.suggestions_row.view.*

class SuggestionsAdapter : BaseSuggestionsAdapter(R.layout.suggestions_row) {

    override val differ = AsyncListDiffer(this, diffCallBack)

    override fun onBindViewHolder(holder: SuggestionsViewHolder, position: Int) {
        val sug = suggestions[position]
        holder.itemView.apply {
            suggestionTitle.text = sug.title

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(sug)
                }
            }
        }
    }
}