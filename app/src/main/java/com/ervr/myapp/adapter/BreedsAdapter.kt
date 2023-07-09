package com.ervr.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ervr.myapp.R
import com.ervr.myapp.model.Breed

class BreedsAdapter(private val breeds: List<Breed>, private val onBreedClickListener: OnBreedClickListener) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {

    interface OnBreedClickListener {
        fun onBreedClick(breed: Breed)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedName: TextView = itemView.findViewById(R.id.breedName)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onBreedClickListener.onBreedClick(breeds[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.breed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breed = breeds[position]
        holder.breedName.text = breed.breed
    }

    override fun getItemCount() = breeds.size
}