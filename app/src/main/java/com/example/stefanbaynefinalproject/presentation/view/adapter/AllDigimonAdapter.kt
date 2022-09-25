package com.example.stefanbaynefinalproject.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stefanbaynefinalproject.R
import com.example.stefanbaynefinalproject.databinding.AllDigimonListItemBinding
import com.example.stefanbaynefinalproject.data.model.Digimon

// Adapter for RecyclerView for API call
class AllDigimonAdapter(private val digimonListItem: List<Digimon>) :
    RecyclerView.Adapter<AllDigimonAdapter.AllDigimonViewHolder>() {

    // Inner class for the ViewHolder.
    class AllDigimonViewHolder(
        // Create binding value to bind items in layout
        private val binding: AllDigimonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        /*
        Using our cardview for binding
         */
        val cardview: CardView = binding.rvDigiAll


        // Call bind method to bind views to RecyclerView from API
        // Use viewBinding to bind the views, and use Glide to pull the image from the API
        fun bind(digimon: Digimon) {
            binding.apply {
                tvName.text = digimon.name.toString()
                tvLevel.text = digimon.level.toString()
                Glide.with(ivDigimonItem).load(digimon.img).into(ivDigimonItem)
            }
        }
    }

    // Create ViewHolder, and inflate layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AllDigimonViewHolder(
            AllDigimonListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

    // Bind ViewHOlder to the position of the listitem
    override fun onBindViewHolder(holder: AllDigimonViewHolder, position: Int) {
        holder.bind(digimonListItem[position])
        holder.cardview.startAnimation(
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim1)
        )
    }

    // Return the item count
    override fun getItemCount(): Int {
        return digimonListItem.size
    }
}