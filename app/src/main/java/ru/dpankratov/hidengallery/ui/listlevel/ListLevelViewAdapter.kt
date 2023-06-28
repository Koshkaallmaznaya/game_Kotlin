package ru.dpankratov.hidengallery.ui.listlevel

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import ru.dpankratov.hidengallery.R

import ru.dpankratov.hidengallery.placeholder.PlaceholderContent.PlaceholderItem
import ru.dpankratov.hidengallery.databinding.ListLevelElementBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 */
class ListLevelViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<ListLevelViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListLevelElementBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if (item.pass) {
            holder.idImage.setImageResource(item.photo)
        } else {
            holder.idImage.setImageResource(R.drawable.rectangle)
        }
        holder.itemView.setOnClickListener {
            val bundle = bundleOf("levelId" to item.id)
            it.findNavController().navigate(R.id.levelFragment2, bundle)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ListLevelElementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val idImage: ImageView = binding.imageView
    }
}