package com.example.stefanbaynefinalproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.stefanbaynefinalproject.R
import com.example.stefanbaynefinalproject.model.RvMainListItem

/**
 * This is the first adapter for the first RecyclerView on the main page.
 * Adapters adapt act as a bridge between the UI and the data source!
 */

class RVMainAdapter(private val imageListItem: List<RvMainListItem>)
    : RecyclerView.Adapter<RVMainAdapter.RvViewHolder>() {

    // Holds the Views for each Character
    class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val rvItemView: ImageView = itemView.findViewById(R.id.imageView)
    }

    // Creates the Views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_main_listitem, parent, false)
        return RvViewHolder(view)
    }

    // Bind the view to the position
    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val digimon = imageListItem[position]
        holder.rvItemView.setImageResource(digimon.imageRV)
    }

    // Returns the count of the list
    override fun getItemCount(): Int {
        return imageListItem.size
    }
}