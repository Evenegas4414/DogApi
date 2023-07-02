package com.ervr.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ervr.myapp.R
import com.ervr.myapp.model.Breed

class BreedsAdapter(private val breeds: List<Breed>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedName: TextView = itemView.findViewById(R.id.breedName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.breed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breed = breeds[position]
        holder.breedName.text = breed.breed.capitalize()
    }

    override fun getItemCount() = breeds.size
}