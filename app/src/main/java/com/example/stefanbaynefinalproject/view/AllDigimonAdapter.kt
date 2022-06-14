package com.example.stefanbaynefinalproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stefanbaynefinalproject.databinding.AllDigimonListItemBinding
import com.example.stefanbaynefinalproject.model.Digimon
import kotlinx.coroutines.NonDisposableHandle.parent

// Adapter for RecyclerView for API call
class AllDigimonAdapter(private val digimonListItem: List<Digimon>):
RecyclerView.Adapter<AllDigimonAdapter.AllDigimonViewHolder>() {

    // Inner class for the ViewHolder.
    inner class AllDigimonViewHolder(
        // Create binding value to bind items in layout
        private val binding: AllDigimonListItemBinding
    ): RecyclerView.ViewHolder(binding.root)
    {
        // Call bind method to bind views to RecyclerView from API
        fun bind(digimon: Digimon) {
            binding.tvName.text = digimon.name.toString()
            binding.tvLevel.text = digimon.level.toString()
            Glide.with(binding.ivDigimonItem).load(digimon.img).into(binding.ivDigimonItem)
        }
    }

    // Create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AllDigimonViewHolder (
        AllDigimonListItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false )
        )

    // Bind ViewHOlder to the position of the listitem
    override fun onBindViewHolder(holder: AllDigimonAdapter.AllDigimonViewHolder, position: Int) {
        holder.bind(digimonListItem[position])
    }

    // Return the item count
    override fun getItemCount(): Int {
        return digimonListItem.size
    }
}