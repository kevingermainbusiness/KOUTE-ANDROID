package ht.koute.android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ht.koute.android.data.Show

abstract class BaseShowsAdapter(private val layoutId: Int) :
    RecyclerView.Adapter<BaseShowsAdapter.MainViewHolder>() {

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    protected val diffCallback = object : DiffUtil.ItemCallback<Show>() {

        override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean {
            return oldItem.mediaId == newItem.mediaId
        }

        override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    // Will be called by children classes
    protected abstract val differ: AsyncListDiffer<Show>

    var shows: List<Show>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    protected var onItemClickListener: ((Show) -> Unit)? = null

    fun setItemClickListener(listener: (Show) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        )
    }

    override fun getItemCount(): Int = shows.size
}