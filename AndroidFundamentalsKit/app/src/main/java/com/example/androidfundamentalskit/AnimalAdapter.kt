package com.example.androidfundamentalskit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalList: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAnimal: ImageView = itemView.findViewById(R.id.imgAnimal)
        val tvName: TextView = itemView.findViewById(R.id.tvAnimalName)
        val tvType: TextView = itemView.findViewById(R.id.tvAnimalType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animalList[position]

        holder.tvName.text = animal.name
        holder.tvType.text = "Вид: ${animal.type}"

        holder.imgAnimal.setImageResource(animal.imageResId)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Вы выбрали: ${animal.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return animalList.size
    }
}