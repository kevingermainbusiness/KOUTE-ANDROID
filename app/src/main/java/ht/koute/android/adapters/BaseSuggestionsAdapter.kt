package ht.koute.android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ht.koute.android.data.Suggestions

abstract class BaseSuggestionsAdapter(private var layoutId: Int) :
    RecyclerView.Adapter<BaseSuggestionsAdapter.SuggestionsViewHolder>() {

    protected val diffCallBack = object : DiffUtil.ItemCallback<Suggestions>() {
        override fun areItemsTheSame(oldItem: Suggestions, newItem: Suggestions): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Suggestions, newItem: Suggestions): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    // Will be called by children classes
    protected abstract val differ: AsyncListDiffer<Suggestions>

    var suggestions: List<Suggestions>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    class SuggestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionsViewHolder {
        return SuggestionsViewHolder(
            LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        )
    }

    override fun getItemCount(): Int = suggestions.size

    // OnItemClickListener Implementation
    protected var onItemClickListener: ((Suggestions) -> Unit)? = null

    fun setItemClickListener(listener: (Suggestions) -> Unit) {
        onItemClickListener = listener
    }
}