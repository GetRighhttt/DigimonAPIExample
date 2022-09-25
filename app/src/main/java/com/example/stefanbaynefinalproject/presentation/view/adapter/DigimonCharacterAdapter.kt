package com.example.stefanbaynefinalproject.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.stefanbaynefinalproject.R
import com.example.stefanbaynefinalproject.presentation.view.recyclerviewlistitem.ListDigimonCharacters

// Adapter for character recyclerView
class DigimonCharacterAdapter(private val imageForCharacters: List<ListDigimonCharacters>)
    : RecyclerView.Adapter<DigimonCharacterAdapter.DigimonViewHolder>() {

    // Holds the Views for each Character
    class DigimonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dgItemView: ImageView = itemView.findViewById(R.id.img_character)
    }

    // Creates the ViewHolder and inflate the views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_list_item, parent, false)
        return DigimonViewHolder(view)
    }

    // Bind the view to the position, and set the image to populate
    override fun onBindViewHolder(holder: DigimonViewHolder, position: Int) {
        val digimon = imageForCharacters[position]
        holder.dgItemView.setImageResource(digimon.imageForCharacters)
    }

    // Returns the count of the list
    override fun getItemCount(): Int {
        return imageForCharacters.size
    }
}