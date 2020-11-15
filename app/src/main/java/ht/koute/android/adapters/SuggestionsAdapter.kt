package ht.koute.android.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import ht.koute.android.R
import kotlinx.android.synthetic.main.suggestions1_row.view.*

class SuggestionsAdapter : BaseSuggestionsAdapter(R.layout.suggestions1_row) {

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